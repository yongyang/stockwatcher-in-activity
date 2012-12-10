package com.google.gwt.stockwatcher.shared;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class Stock implements Serializable{
    private String code;
    private double price;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock fromString(String placeToken) {
        return null;
    }
}
