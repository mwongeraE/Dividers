package com.example.mwongera.dividers;

public class BookCover implements Media {

    public static final String MEDIA_TYPE = "BookCover";

    private final int coverImageId;

    @Override public String getType() {
        return MEDIA_TYPE;
    }

    public BookCover(int coverImageId) {
        this.coverImageId = coverImageId;
    }

    public int getCoverImageId() {
        return coverImageId;
    }
}