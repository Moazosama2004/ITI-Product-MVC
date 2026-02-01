package com.example.mvc_iti.data.products.products.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.db.AppDatabase;

import java.util.List;

public class ProductsLocalDataSource {
    private final ProductsDAO productsDAO;

    public ProductsLocalDataSource(Context context) {
        this.productsDAO = AppDatabase.getINSTANCE(context).productsDAO();
    }

    public void insertProduct(Product product) {
        new Thread(() -> {
            productsDAO.addToFav(product);
        }).start();
    }

    public void deleteProduct(Product product) {
        new Thread(() -> {
            productsDAO.deleteFromFav(product);
        }).start();
    }

    public LiveData<List<Product>> getAllProducts() {
        return productsDAO.getAllProducts();
    }
}
