package com.example.mvc_iti.presentation.allproducts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvc_iti.R;
import com.example.mvc_iti.data.products.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private final ProductOnClickListener movieOnClickListener;


    public ProductAdapter(ProductOnClickListener movieOnClickListener) {
        this.productList = new ArrayList<>();
        this.movieOnClickListener = movieOnClickListener;
    }

    public void setMovieList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ImageView movieImageView;
        private final TextView movieTitleTextView;
        private final TextView movieCategoryTextView;
        private final Button addToFavoritesButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.iv_poster);
            movieTitleTextView = itemView.findViewById(R.id.tv_name);
            movieCategoryTextView = itemView.findViewById(R.id.tv_category);
            addToFavoritesButton = itemView.findViewById(R.id.btn_addToFav);
        }

        public void bind(Product product) {
            movieTitleTextView.setText(product.getTitle());
            movieCategoryTextView.setText(product.getDescription());
            addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieOnClickListener.addProductToFav(product);
                }
            });
            Glide.with(itemView)
                    .load(product.getImageUrl())
                    .into(movieImageView);

        }
    }
}

