package com.example.mvc_iti.presentation.allproducts.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.R;
import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.presentation.allproducts.presenter.ProductsPresenter;
import com.example.mvc_iti.presentation.allproducts.presenter.ProductsPresenterImp;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements ProductOnClickListener, ProductsView {

    RecyclerView rvMovies;
    ProductAdapter adapter;
    ProductsPresenter presenter;
    ProgressBar progressBar;
    TextView errorTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        rvMovies = findViewById(R.id.rv_movies);
        progressBar = findViewById(R.id.progress_circular);
        errorTextView = findViewById(R.id.tv_error);
        adapter = new ProductAdapter(this);
        rvMovies.setAdapter(adapter);

        presenter = new ProductsPresenterImp(getApplication(), this);
        presenter.getAllProducts();
    }

    @Override
    public void addProductToFav(Product product) {
        presenter.addToFav(product);
    }

    @Override
    public void showProducts(List<Product> products) {
        adapter.setMovieList(products);
    }

    @Override
    public void showError(String errMessage) {
        progressBar.setVisibility(View.GONE);
        errorTextView.setText(errMessage);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}