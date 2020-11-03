package com.example.ezyfood;

public class Product {
    private String name;
    private int price;
    private int qty;
    private int image;

    public Product(String name, int price, int qty, int image) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
