package com.example.zorkohtt2.adapter;

public class CartItem {

    private final String name;
    private final String price;
    private final int image; // Assuming image is an integer resource ID

    public CartItem(String name, String price) {
        this.name = name;
        this.price = price;
        this.image = 0; // Or set a default image resource here if applicable
    }

    public CartItem(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}