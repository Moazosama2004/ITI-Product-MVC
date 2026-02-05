package com.example.mvc_iti.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.model.ProductsResponse;
import com.example.mvc_iti.data.products.products.datasource.local.ProductsLocalDataSource;
import com.example.mvc_iti.data.products.products.datasource.remote.ProductsNetworkResponse;
import com.example.mvc_iti.data.products.products.datasource.remote.ProductsRemoteDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ProductsRepo {

    ProductsRemoteDataSource productsRemoteDataSource;
    ProductsLocalDataSource productsLocalDataSource;


    public ProductsRepo(Application application) {
        this.productsLocalDataSource = new ProductsLocalDataSource(application);
        this.productsRemoteDataSource = new ProductsRemoteDataSource();
    }

    public Observable<ProductsResponse> getAllProducts() {
        return productsRemoteDataSource.getAllProducts();
    }

    public Completable addToFav(Product product) {
       return productsLocalDataSource.insertProduct(product);
    }

    public Completable deleteProduct(Product product) {
        return productsLocalDataSource.deleteProduct(product);
    }

    public Single<List<Product>> getFavProducts() {
        return productsLocalDataSource.getAllProducts();
    }
}
