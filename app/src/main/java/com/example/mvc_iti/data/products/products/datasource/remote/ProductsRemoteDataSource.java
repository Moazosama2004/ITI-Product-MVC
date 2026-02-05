package com.example.mvc_iti.data.products.products.datasource.remote;

import com.example.mvc_iti.data.products.model.ProductsResponse;
import com.example.mvc_iti.network.Network;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ProductsRemoteDataSource {
    private final ProductsService productsService;

    public ProductsRemoteDataSource() {
        this.productsService = new Network().getProductsService();
    }

    public Observable<ProductsResponse> getAllProducts() {
        return productsService.getAllProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
