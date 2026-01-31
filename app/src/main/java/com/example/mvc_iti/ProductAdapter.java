package com.example.mvc_iti;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvc_iti.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;


    public ProductAdapter() {
        this.productList = new ArrayList<>();
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
        private ImageView movieImageView;
        private TextView movieTitleTextView;
        private TextView movieCategoryTextView;
        private Button addToFavoritesButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.iv_poster);
            movieTitleTextView = itemView.findViewById(R.id.tv_name);
            movieCategoryTextView = itemView.findViewById(R.id.tv_category);
            addToFavoritesButton = itemView.findViewById(R.id.btn_addToFav);
        }

        public void bind(Product product) {
            movieTitleTextView.setText(product.getName());
            movieCategoryTextView.setText(product.getDescription());
//            Glide.with(itemView)
//                    .load(product.getPoster())
//                    .into(movieImageView);

        }
    }
}

