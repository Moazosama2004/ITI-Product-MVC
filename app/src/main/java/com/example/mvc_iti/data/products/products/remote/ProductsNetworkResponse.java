package com.example.mvc_iti.data.products.products.remote;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

public interface ProductsNetworkResponse {
    void onSuccess(List<Product> products);

    void noInternetConnection(String errMessage);

    void onError(String errorMessage);

}
