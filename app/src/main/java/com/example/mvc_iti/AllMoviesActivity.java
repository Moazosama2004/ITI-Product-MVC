package com.example.mvc_iti;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.model.Product;
import com.example.mvc_iti.network.Network;
import com.example.mvc_iti.network.ProductsResponse;
import com.example.mvc_iti.network.ProductsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllMoviesActivity extends AppCompatActivity {

    RecyclerView rvMovies;
    ProductAdapter adapter;
    ProductsService productsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        rvMovies = findViewById(R.id.rv_movies);
        adapter = new ProductAdapter();
        rvMovies.setAdapter(adapter);
        productsService = new Network().getProductsService();
        productsService.getAllProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if(response.code() == 200){
                    ProductsResponse productsResponse = response.body();
                    List<Product> productList = productsResponse.getProducts();
                    Log.d("TAG", "onResponsekkkk: " + productList.size());
                    adapter.setMovieList(productList);
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });

    }
}