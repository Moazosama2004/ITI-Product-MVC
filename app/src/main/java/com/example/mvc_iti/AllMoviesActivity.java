package com.example.mvc_iti;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AllMoviesActivity extends AppCompatActivity {

    RecyclerView rvMovies;
    ProductAdapter adapter;
    Network network;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        rvMovies = findViewById(R.id.rv_movies);
        adapter = new ProductAdapter();
        rvMovies.setAdapter(adapter);
        network = new Network();
        adapter.setMovieList(network.getAllProducts());

    }
}