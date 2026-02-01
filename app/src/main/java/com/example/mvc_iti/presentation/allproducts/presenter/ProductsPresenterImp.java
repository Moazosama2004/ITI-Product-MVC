package com.example.mvc_iti.presentation.allproducts.presenter;

import android.app.Application;
import android.util.Log;

import com.example.mvc_iti.data.ProductsRepo;
import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.remote.ProductsNetworkResponse;
import com.example.mvc_iti.presentation.allproducts.view.ProductsView;

import java.util.List;

public class ProductsPresenterImp implements ProductsPresenter {
    ProductsRepo productsRepo;
    ProductsView productsView;

    public ProductsPresenterImp(Application application, ProductsView productsView) {
        productsRepo = new ProductsRepo(application);
        this.productsView = productsView;
    }


    @Override
    public void getAllProducts() {
        Log.d("Moaz", "ProductsPresenterImp -> getAllProducts");
        productsView.showLoading();
        productsRepo.getAllProducts(new ProductsNetworkResponse() {
            @Override
            public void onSuccess(List<Product> products) {
                Log.d("Moaz", "ProductsPresenterImp -> onSuccess");
                productsView.hideLoading();
                productsView.showProducts(products);
            }

            @Override
            public void noInternetConnection(String errMessage) {
                productsView.hideLoading();
                productsView.showError("No Internet Connection");

            }

            @Override
            public void onError(String errMessage) {
                productsView.hideLoading();
                productsView.showError(errMessage);
            }
        });
    }

    @Override
    public void addToFav(Product product) {
        productsRepo.addToFav(product);
    }

}
