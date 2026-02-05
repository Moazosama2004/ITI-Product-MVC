package com.example.mvc_iti.data.products.products.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.db.AppDatabase;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


public class ProductsLocalDataSource {
    private final ProductsDAO productsDAO;

    public ProductsLocalDataSource(Context context) {
        this.productsDAO = AppDatabase.getINSTANCE(context).productsDAO();
    }

    public Completable insertProduct(Product product) {
        return productsDAO.addToFav(product);
    }

    public Completable deleteProduct(Product product) {
        return productsDAO.deleteFromFav(product);
    }

    public Single<List<Product>> getAllProducts() {
        return productsDAO.getAllProducts();
    }
}
