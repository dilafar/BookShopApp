package com.example.appbookshop.Model;

public class OrdersModel {
    int orderimage;
    String ordername,ordernumber,price ,qty,offer;

    public OrdersModel(int orderimage, String ordername, String ordernumber, String price, String qty, String offer) {
        this.orderimage = orderimage;
        this.ordername = ordername;
        this.ordernumber = ordernumber;
        this.price = price;
        this.qty = qty;
        this.offer = offer;
    }

    public OrdersModel() {

    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
}
