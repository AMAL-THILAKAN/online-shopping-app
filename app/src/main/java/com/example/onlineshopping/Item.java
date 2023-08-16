package com.example.onlineshopping;

public class Item {

    String item_name;
    String description;
    String price;
    int image;


    public Item(String item_name, String description, String price, int image) {
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public  String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
