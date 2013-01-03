package com.google.gwt.stockwatcher.client;

import com.google.gwt.stockwatcher.shared.Stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyang
 * Date: 12-12-31
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class ClientSession implements Serializable {

    private List<Stock> availableStocks = new ArrayList<Stock>();

    private List<Stock> boughtStocks = new ArrayList<Stock>();

    private static final ClientSession INSTANCE = new ClientSession();

    private ClientSession() {
    }

    public static ClientSession getInstance() {
        return INSTANCE;
    }

    public List<Stock> getAvailableStocks() {
        for(Stock stock : availableStocks){
            stock.updatePrice();
        }
        return availableStocks;
    }

    public List<Stock> getBoughtStocks() {
        return boughtStocks;
    }

    public void addStock(Stock stock) {
        availableStocks.add(stock);
    }
}
