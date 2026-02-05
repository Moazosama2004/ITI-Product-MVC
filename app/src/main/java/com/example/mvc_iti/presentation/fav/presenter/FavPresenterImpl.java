package com.example.mvc_iti.presentation.fav.presenter;

import android.content.Context;
import android.util.Log;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.datasource.local.ProductsLocalDataSource;
import com.example.mvc_iti.presentation.fav.view.FavView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;

public class FavPresenterImpl implements FavPresenter {

    private final ProductsLocalDataSource productsLocalDataSource;
    private final FavView favView;
    private final CompositeDisposable compositeDisposable;

    public FavPresenterImpl(Context context, FavView favView) {
        this.productsLocalDataSource = new ProductsLocalDataSource(context);
        this.favView = favView;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getFavProducts() {
        compositeDisposable.add(
                productsLocalDataSource.getAllProducts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                products -> favView.showFavProducts(products),
                                throwable -> {
                                    Log.e("FavPresenter", "Error loading favorites", throwable);
                                    favView.showError("Failed to load favorites");
                                }
                        )
        );
    }

    @Override
    public void deleteFromFav(Product product) {
        compositeDisposable.add(
                productsLocalDataSource.deleteProduct(product)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                () -> getFavProducts(),
                                throwable -> {
                                    Log.e("FavPresenter", "Error deleting favorite", throwable);
                                    favView.showError("Failed to delete favorite");
                                }
                        )
        );
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
