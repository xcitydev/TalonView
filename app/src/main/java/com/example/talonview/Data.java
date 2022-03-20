package com.example.talonview;

public class Data {
    public Data(String coinName, int img, String coinPrice, String coinValue, String coinAmt, String coinEqv) {
        this.coinName = coinName;
        this.img = img;
        this.coinPrice = coinPrice;
        this.coinValue = coinValue;
        this.coinAmt = coinAmt;
        this.coinEqv = coinEqv;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(String coinPrice) {
        this.coinPrice = coinPrice;
    }

    public String getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(String coinValue) {
        this.coinValue = coinValue;
    }

    public String getCoinAmt() {
        return coinAmt;
    }

    public void setCoinAmt(String coinAmt) {
        this.coinAmt = coinAmt;
    }

    public String getCoinEqv() {
        return coinEqv;
    }

    public void setCoinEqv(String coinEqv) {
        this.coinEqv = coinEqv;
    }

    public String coinName;
    public int img;
    public String coinPrice;
    public String coinValue;
    public String coinAmt;
    public String coinEqv;
}
