package com.example.mvc_iti.presentation.fav.view;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

public interface FavView {
    void showFavProducts(List<Product> products);
    void showError(String message);
}