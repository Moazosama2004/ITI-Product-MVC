package com.example.mvc_iti;

import com.example.mvc_iti.model.Product;

import java.util.List;

public class Network {

    public List<Product> getAllProducts() {
        return List.of(
                new Product("Samsung Galaxy S21 Ultra ", "image_url", "Samsung Galaxy S21 Ultra", 1200),
                new Product("iPhone 13 Pro Max", "image_url", "iPhone 13 Pro Max", 1000),
                new Product("OnePlus 9 Pro", "image_url", "OnePlus 9 Pro", 800)

        );
    }
}
