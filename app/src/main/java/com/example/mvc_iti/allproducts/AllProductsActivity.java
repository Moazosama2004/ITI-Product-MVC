package com.example.mvc_iti.allproducts;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.R;
import com.example.mvc_iti.datasource.ProductsNetworkResponse;
import com.example.mvc_iti.datasource.ProductsRemoteDataSource;
import com.example.mvc_iti.model.Product;
import com.example.mvc_iti.datasource.ProductsService;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements ProductOnClickListener {

    RecyclerView rvMovies;
    ProductAdapter adapter;
    ProductsService productsService;

    ProgressBar progressBar;
    TextView errorTextView;
    ProductsRemoteDataSource remoteDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        rvMovies = findViewById(R.id.rv_movies);
        progressBar = findViewById(R.id.progress_circular);
        errorTextView = findViewById(R.id.tv_error);
        adapter = new ProductAdapter(this);
        rvMovies.setAdapter(adapter);
        remoteDataSource = new ProductsRemoteDataSource(productsService);
        remoteDataSource.getAllProducts(new ProductsNetworkResponse() {
            @Override
            public void onSuccess(List<Product> products) {
                adapter.setMovieList(products);
                progressBar.setVisibility(View.GONE);
                errorTextView.setVisibility(View.GONE);
            }

            @Override
            public void noInternetConnection(String errMessage) {
                progressBar.setVisibility(View.GONE);
                errorTextView.setText(errMessage);
                errorTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String errorMessage) {
                progressBar.setVisibility(View.GONE);
                errorTextView.setText(errorMessage);
                errorTextView.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void addProductToFav(Product product) {

    }
}