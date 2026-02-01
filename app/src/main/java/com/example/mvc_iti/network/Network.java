package com.example.mvc_iti.network;

import com.example.mvc_iti.data.products.products.remote.ProductsService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static Retrofit retrofit;
    private ProductsService productsService;

    public Network() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ProductsService getProductsService() {
        if (productsService == null) {
            productsService = retrofit.create(ProductsService.class);
        }
        return productsService;
    }
}
