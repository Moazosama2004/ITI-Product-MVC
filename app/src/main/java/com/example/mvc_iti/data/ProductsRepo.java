package com.example.mvc_iti.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.local.ProductsLocalDataSource;
import com.example.mvc_iti.data.products.products.remote.ProductsNetworkResponse;
import com.example.mvc_iti.data.products.products.remote.ProductsRemoteDataSource;

import java.util.List;

public class ProductsRepo {

    ProductsRemoteDataSource productsRemoteDataSource;
    ProductsLocalDataSource productsLocalDataSource;


    public ProductsRepo(Application application) {
        this.productsLocalDataSource = new ProductsLocalDataSource(application);
        this.productsRemoteDataSource = new ProductsRemoteDataSource();
    }

    public void getAllProducts(ProductsNetworkResponse productsNetworkResponse) {
        productsRemoteDataSource.getAllProducts(productsNetworkResponse);
    }

    public void addToFav(Product product) {
        productsLocalDataSource.insertProduct(product);
    }

    public void deleteProduct(Product product) {
        productsLocalDataSource.deleteProduct(product);
    }

    public LiveData<List<Product>> getFavProducts() {
        return productsLocalDataSource.getAllProducts();
    }
}
