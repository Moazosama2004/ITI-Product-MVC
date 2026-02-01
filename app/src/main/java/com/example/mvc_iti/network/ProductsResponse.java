package com.example.mvc_iti.network;

import com.example.mvc_iti.model.Product;

import java.util.List;

public class ProductsResponse {
    private List<Product> products;

    public ProductsResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
