package com.example.githubrepodisplay;

public class Chairs {
    private String name;
    private String collYear;
    private double price;
    private int image;
    private float rating;
    private boolean favourite;

    public Chairs(String name, String collYear, double price, int image, float rating, boolean favourite) {
        this.name = name;
        this.collYear = collYear;
        this.price = price;
        this.image = image;
        this.rating = rating;
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollYear() {
        return collYear;
    }

    public void setCollYear(String collYear) {
        this.collYear = collYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
