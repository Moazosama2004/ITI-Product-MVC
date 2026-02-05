package com.example.mvc_iti.presentation.fav.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.R;
import com.example.mvc_iti.data.products.model.Product;
import com.example.mvc_iti.presentation.fav.presenter.FavPresenter;
import com.example.mvc_iti.presentation.fav.presenter.FavPresenterImpl;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavActivity extends AppCompatActivity implements OnFavoriteClickListener , FavView{

    RecyclerView rvFavMovies;
    FavProductsAdapter adapter;
    FavPresenter favPresenter;
    private CompositeDisposable compositeDisposable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        rvFavMovies = findViewById(R.id.rvFavMovies);
        adapter = new FavProductsAdapter(this);
        rvFavMovies.setAdapter(adapter);
        favPresenter = new FavPresenterImpl(getApplicationContext() ,this);
        compositeDisposable = new CompositeDisposable();
        favPresenter.getFavProducts();
    }


    @Override
    public void onClick(Product product) {
        favPresenter.deleteFromFav(product);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }



    @Override
    public void showFavProducts(List<Product> products) {
        adapter.setList(products);
    }

    @Override
    public void showError(String message) {

    }
}