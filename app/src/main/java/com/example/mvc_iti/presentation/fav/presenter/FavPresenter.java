package com.example.mvc_iti.presentation.fav.presenter;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

public interface FavPresenter {
    LiveData<List<Product>> getFavProducts();

    void deleteFromFav(Product product);
}
