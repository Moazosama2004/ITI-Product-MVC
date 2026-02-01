package com.example.mvc_iti.presentation.fav.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.R;
import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.presentation.fav.presenter.FavPresenter;
import com.example.mvc_iti.presentation.fav.presenter.FavPresenterImpl;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavoriteClickListener {

    RecyclerView rvFavMovies;
    FavProductsAdapter adapter;
    FavPresenter favPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        rvFavMovies = findViewById(R.id.rvFavMovies);
        adapter = new FavProductsAdapter(this);
        rvFavMovies.setAdapter(adapter);
        favPresenter = new FavPresenterImpl(getApplicationContext());
        favPresenter.getFavProducts().observe(
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
        favPresenter.deleteFromFav(product);
    }
}