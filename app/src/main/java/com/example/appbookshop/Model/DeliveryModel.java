package com.example.appbookshop.Model;

public class DeliveryModel {
    String deliveryID,totalpay,name,phone,address,status;

    public DeliveryModel(String deliveryID, String totalpay, String name, String phone, String address, String status) {
        this.deliveryID = deliveryID;
        this.totalpay = totalpay;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public DeliveryModel(){

    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(String totalpay) {
        this.totalpay = totalpay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
