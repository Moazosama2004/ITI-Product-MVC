package com.example.mvc_iti.model;

public class Product {
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public Product(String description, String imageUrl, String name, double price) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
