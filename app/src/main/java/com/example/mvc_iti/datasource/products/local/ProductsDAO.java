package com.example.mvc_iti.datasource.products.local;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvc_iti.model.Product;

import java.util.List;

@Dao
public interface ProductsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addToFav(Product product);

    @Delete
    void deleteFromFav(Product product);

    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAllProducts();
}
