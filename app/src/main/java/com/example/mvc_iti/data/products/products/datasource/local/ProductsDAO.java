package com.example.mvc_iti.data.products.products.datasource.local;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvc_iti.data.products.model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface ProductsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addToFav(Product product);

    @Delete
    Completable deleteFromFav(Product product);

    @Query("SELECT * FROM products")
    Single<List<Product>> getAllProducts();
}
