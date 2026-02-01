package com.example.mvc_iti.datasource;

import com.example.mvc_iti.model.Product;
import com.example.mvc_iti.model.ProductsResponse;
import com.example.mvc_iti.network.Network;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRemoteDataSource {
    private ProductsService productsService;

    public ProductsRemoteDataSource(ProductsService productsService) {
        this.productsService = new Network().getProductsService();
    }

    public void getAllProducts(ProductsNetworkResponse networkResponse){
        productsService.getAllProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if(response.code() == 200){
                    ProductsResponse productsResponse = response.body();
                    List<Product> productList = productsResponse.getProducts();
                    networkResponse.onSuccess(productList);
                } else {
                    networkResponse.onError("Error occurred while fetching data!");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                if(t instanceof IOException){
                    networkResponse.noInternetConnection("No internet connection");
                }else {
                    networkResponse.onError("Error occurred while fetching data!");
                }
            }
        });
    }
}
