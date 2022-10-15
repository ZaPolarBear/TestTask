package com.zpb.testtask.models;

public class FoodDisplayModel {
    private String Name;
    private String Description;
    private String Price;
    private String ImageUrl;

    public FoodDisplayModel(String name, String description, String price, String imageUrl) {
        this.Name = name;
        this.Description = description;
        this.Price = price;
        this.ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
