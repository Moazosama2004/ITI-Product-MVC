package com.example.mvc_iti.presentation.fav.presenter;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.local.ProductsLocalDataSource;

import java.util.List;

public class FavPresenterImpl implements FavPresenter {
    ProductsLocalDataSource productsLocalDataSource;

    public FavPresenterImpl(Context context) {
        this.productsLocalDataSource = new ProductsLocalDataSource(context);
    }

    @Override
    public LiveData<List<Product>> getFavProducts() {
        return productsLocalDataSource.getAllProducts();
    }

    @Override
    public void deleteFromFav(Product product) {
        productsLocalDataSource.deleteProduct(product);
    }
}
