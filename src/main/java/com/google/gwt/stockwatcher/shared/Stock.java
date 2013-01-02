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
    private String symbol;
    private double price;

    private double change;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChange() {
        return change;
    }

    public Stock fromString(String placeToken) {
        return null;
    }
}
