package com.example.mvc_iti.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvc_iti.datasource.products.local.ProductsDAO;
import com.example.mvc_iti.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductsDAO productsDAO();
    private static AppDatabase INSTANCE;

    private static final String DATABASE_NAME = "products_db";


    public static AppDatabase getINSTANCE(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "products_db").build();
        }
        return INSTANCE;
    }
}
