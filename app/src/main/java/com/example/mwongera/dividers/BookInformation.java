package com.example.mwongera.dividers;

public class BookInformation implements Media {

    public static final String MEDIA_TYPE = "BookInformation";

    private final String title;
    private final String author;

    @Override
    public String getType() {
        return MEDIA_TYPE;
    }

    public BookInformation(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}