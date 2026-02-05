package com.example.mvc_iti.data.products.products.datasource.remote;


import com.example.mvc_iti.data.products.model.ProductsResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsService {

    @GET("products")
    Observable<ProductsResponse> getAllProducts();
}
