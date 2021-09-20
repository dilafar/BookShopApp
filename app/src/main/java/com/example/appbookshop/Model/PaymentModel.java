package com.example.appbookshop.Model;

public class PaymentModel {
    String cardname,cardnumber,expirydate,ccv,uname,totalpay,paymentdate,paymentID;

    public PaymentModel(String cardname, String cardnumber, String expirydate, String ccv, String uname, String totalpay, String paymentdate, String paymentID) {
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expirydate = expirydate;
        this.ccv = ccv;
        this.uname = uname;
        this.totalpay = totalpay;
        this.paymentdate = paymentdate;
        this.paymentID = paymentID;
    }

    public PaymentModel(){

    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(String totalpay) {
        this.totalpay = totalpay;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
}
