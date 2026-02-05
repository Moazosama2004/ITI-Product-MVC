package com.example.mvc_iti.presentation.allproducts.presenter;

import android.app.Application;
import android.util.Log;

import com.example.mvc_iti.data.ProductsRepo;
import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.datasource.remote.ProductsNetworkResponse;
import com.example.mvc_iti.presentation.allproducts.view.ProductsView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductsPresenterImp implements ProductsPresenter {
    ProductsRepo productsRepo;
    ProductsView productsView;
    CompositeDisposable compositeDisposable;

    public ProductsPresenterImp(Application application, ProductsView productsView) {
        productsRepo = new ProductsRepo(application);
        this.productsView = productsView;
        this.compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void getAllProducts() {
        Log.d("Moaz", "ProductsPresenterImp -> getAllProducts");
        productsView.showLoading();

        Disposable disposable = productsRepo.getAllProducts()
                .subscribe(
                        productsResponse -> {
                            productsView.hideLoading();
                            List<Product> products = productsResponse.getProducts();
                            if (products != null && !products.isEmpty()) {
                                productsView.showProducts(products);
                            } else {
                                productsView.showError("No products available");
                            }
                        },
                        throwable -> {
                            Log.e("Moaz", "Error fetching products", throwable);
                            productsView.hideLoading();
                            productsView.showError(throwable.getMessage() != null ? throwable.getMessage() : "Unknown error");
                        }
                );

        compositeDisposable.add(disposable);
    }


    @Override
    public void addToFav(Product product) {
        if (product == null) {
            Log.w("Moaz", "addToFav called with null product");
            return;
        }

        Disposable disposable = productsRepo.addToFav(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        () -> Log.d("Moaz", "Product added to favorites successfully"),
                        throwable -> Log.e("Moaz", "Error adding product to favorites", throwable)
                );

        compositeDisposable.add(disposable);
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }

}
