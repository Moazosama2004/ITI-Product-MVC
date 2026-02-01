package com.example.mvc_iti.fav;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.R;
import com.example.mvc_iti.datasource.products.local.ProductsLocalDataSource;
import com.example.mvc_iti.model.Product;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavoriteClickListener{

    RecyclerView rvFavMovies;
    FavProductsAdapter adapter;
    ProductsLocalDataSource productsLocalDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        rvFavMovies = findViewById(R.id.rvFavMovies);
        adapter = new FavProductsAdapter(this);
        rvFavMovies.setAdapter(adapter);
        productsLocalDataSource = new ProductsLocalDataSource(getApplicationContext());
        productsLocalDataSource.getAllProducts().observe(
                this,
                new Observer<List<Product>>() {
                    @Override
                    public void onChanged(List<Product> products) {
                        adapter.setList(products);
                    }
                }
        );
    }


    @Override
    public void onClick(Product product) {
        productsLocalDataSource.deleteProduct(product);
    }
}