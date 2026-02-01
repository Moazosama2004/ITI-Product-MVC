package com.example.mvc_iti.data.products.products.remote;

import com.example.mvc_iti.data.products.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsService {

    @GET("products")
    Call<ProductsResponse> getAllProducts();
}
