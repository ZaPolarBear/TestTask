package com.zpb.testtask.models;

public class BannerModel {

    private String ImageUrl;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public BannerModel(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
