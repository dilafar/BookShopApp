package com.example.appbookshop.Model;

public class MainModel {
    int pimage;
    String pname,pdiscription,pavqty,price,offer,itemID,category;

    public MainModel(int pimage, String pname, String pdiscription, String pavqty, String price, String offer, String itemID, String category) {
        this.pimage = pimage;
        this.pname = pname;
        this.pdiscription = pdiscription;
        this.pavqty = pavqty;
        this.price = price;
        this.offer = offer;
        this.itemID = itemID;
        this.category = category;
    }
    public MainModel(){

    }

    public int getPimage() {
        return pimage;
    }

    public void setPimage(int pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdiscription() {
        return pdiscription;
    }

    public void setPdiscription(String pdiscription) {
        this.pdiscription = pdiscription;
    }

    public String getPavqty() {
        return pavqty;
    }

    public void setPavqty(String pavqty) {
        this.pavqty = pavqty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
