package com.example.mwongera.dividers;

/**
 * Created by mwongera on 3/22/16.
 */
public class Movie {
    private final String title;
    private final String director;
    private final int rating;
    private final int imageResourceId;

    public Movie(String title, String director, int rating, int imageResourceId) {
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public int getCoverResourceId() {
        return imageResourceId;
    }
}
