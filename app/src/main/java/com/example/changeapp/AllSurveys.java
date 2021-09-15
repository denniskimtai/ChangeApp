package com.example.changeapp;

public class AllSurveys {

    private String title;
    private String shortdesc;
    private int image;

    public AllSurveys(String title, String shortdesc, int image) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
