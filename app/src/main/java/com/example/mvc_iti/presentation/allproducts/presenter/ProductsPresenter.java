package com.example.mvc_iti.presentation.allproducts.presenter;

import com.example.mvc_iti.data.products.model.Product;

// Activity -> Presenter
public interface ProductsPresenter {
    void getAllProducts();

    void addToFav(Product product);
}
