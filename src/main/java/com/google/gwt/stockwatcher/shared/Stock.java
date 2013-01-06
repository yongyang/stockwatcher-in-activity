package com.google.gwt.stockwatcher.shared;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class Stock implements Serializable{

    @NotNull
    @Size(min = 4, message = "Symbol must be at least 4 characters.")
    private String symbol;
    private double price;

    private double change;

    public Stock() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }

    public double getChangePercent() {
        return 100.0 * this.change / this.price;
    }

    public Stock fromString(String placeToken) {
        //TODO:
        return null;
    }


    public void updatePrice() {
        Random rnd = new Random();
        price = rnd.nextDouble() * MAX_PRICE;
        change = price * MAX_PRICE_CHANGE
                * (rnd.nextDouble() * 2f - 1f);

    }

    private static final double MAX_PRICE = 100.0; // $100.00
    private static final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

}
