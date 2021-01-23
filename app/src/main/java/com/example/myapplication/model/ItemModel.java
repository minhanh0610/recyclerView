package com.example.myapplication.model;

public class ItemModel {
    String title;
    int imangeResource;
    boolean isLeft ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImangeResource() {
        return imangeResource;
    }

    public void setImangeResource(int imangeResource) {
        this.imangeResource = imangeResource;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public ItemModel(String title, int imangeResource) {
        this.title = title;
        this.imangeResource = imangeResource;
        this.isLeft = true;
    }


    public ItemModel(String title, int imangeResource, boolean isLeft) {
        this.title = title;
        this.imangeResource = imangeResource;
        this.isLeft = isLeft;
    }

}
