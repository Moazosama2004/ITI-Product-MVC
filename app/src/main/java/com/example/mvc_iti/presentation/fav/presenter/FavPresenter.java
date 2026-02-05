package com.example.mvc_iti.presentation.fav.presenter;

import androidx.lifecycle.LiveData;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface FavPresenter {
    void getFavProducts();

    void deleteFromFav(Product product);
    void onDestroy();
}

