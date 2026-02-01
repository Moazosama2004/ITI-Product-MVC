package com.example.mvc_iti.fav;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvc_iti.R;
import com.example.mvc_iti.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FavProductsAdapter extends RecyclerView.Adapter<FavProductsAdapter.ViewHolder>{
    private List<Product> products;
    public OnFavoriteClickListener listener;
    public static final String TAG = "FavoriteAdapter";

    public FavProductsAdapter(OnFavoriteClickListener listener){
        this.products = new ArrayList<>();
        this.listener= listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_favorite, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.i(TAG, "=========== onCreateViewHolder =========== ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setList(List<Product> updatedProducts){
        this.products = updatedProducts;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView favProductImg;
        TextView favProductName;
        TextView favProductPric;
        Button removeFavBtn;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.constraint_fav_movie);
            favProductName = itemView.findViewById(R.id.tv_fav_name);
            favProductPric = itemView.findViewById(R.id.tv_fav_category);
            removeFavBtn = itemView.findViewById(R.id.btn_fav_delete);
            favProductImg = itemView.findViewById(R.id.iv_fav_poster);
        }

        void bind(Product product) {
            favProductName.setText(product.getTitle());
            favProductPric.setText(String.valueOf(product.getPrice()));
            Glide.with(itemView.getContext())
                    .load(product.getImageUrl())
                    .centerCrop()
                    .into(favProductImg);

            removeFavBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(product);
                }
            });
        }
    }
}