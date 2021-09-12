package com.example.appbookshop.Model;

public class CategoryModel {
    String categoryname,categoryID;

    public CategoryModel(String categoryname, String categoryID) {
        this.categoryname = categoryname;
        this.categoryID = categoryID;
    }

    public CategoryModel(){

    }


    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
}
