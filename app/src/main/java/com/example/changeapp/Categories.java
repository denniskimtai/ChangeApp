package com.example.changeapp;

public class Categories {

    private int icon, backgroundColor;
    private String title;


    public Categories(int icon, String title, int backgroundColor) {
        this.icon = icon;
        this.title = title;
        this.backgroundColor = backgroundColor;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
