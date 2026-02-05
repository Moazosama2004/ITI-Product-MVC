package com.example.mvc_iti.presentation.allproducts.view;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

// Presenter -> Activity
public interface ProductsView {
    void showProducts(List<Product> products);

    void showError(String errMessage);

    void showLoading();

    void hideLoading();

}


