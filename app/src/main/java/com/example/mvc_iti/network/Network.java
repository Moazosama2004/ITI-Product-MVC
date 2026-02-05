package com.example.mvc_iti.network;

import android.database.Observable;

import com.example.mvc_iti.data.products.model.ProductsResponse;
import com.example.mvc_iti.data.products.products.datasource.remote.ProductsService;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static Retrofit retrofit;
    private ProductsService productsService;

    public Network() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }


    public ProductsService getProductsService() {
        if (productsService == null) {
            productsService = retrofit.create(ProductsService.class);
        }
        return productsService;
    }
}
