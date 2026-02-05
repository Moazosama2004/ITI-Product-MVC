package com.example.mvc_iti.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.data.products.products.datasource.local.ProductsDAO;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "products_db";
    private static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "products_db").build();
        }
        return INSTANCE;
    }

    public abstract ProductsDAO productsDAO();
}
