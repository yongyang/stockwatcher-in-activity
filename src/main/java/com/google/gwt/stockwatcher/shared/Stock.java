package com.google.gwt.stockwatcher.shared;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class Stock implements Serializable{

    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters long.")
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
