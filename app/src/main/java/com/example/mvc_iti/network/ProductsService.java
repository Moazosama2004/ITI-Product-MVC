package com.example.mvc_iti.network;

import com.example.mvc_iti.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsService {

    @GET("products")
    Call<ProductsResponse> getAllProducts();
}
