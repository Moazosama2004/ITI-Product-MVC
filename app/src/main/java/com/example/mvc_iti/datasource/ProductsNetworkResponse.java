package com.example.mvc_iti.datasource;

import com.example.mvc_iti.model.Product;

import java.util.List;

public interface ProductsNetworkResponse {
    void onSuccess(List<Product> products);
    void noInternetConnection(String errMessage);
    void onError(String errorMessage);

}
