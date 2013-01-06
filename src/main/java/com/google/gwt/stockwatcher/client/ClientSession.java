package com.google.gwt.stockwatcher.client;

import com.google.gwt.stockwatcher.shared.Stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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

    public int getAvailableStockCount() {
        return availableStocks.size();
    }
    public int getBoughtStockCount() {
        return boughtStocks.size();
    }

    public List<Stock> getBoughtStocks() {
        return boughtStocks;
    }

    public void addStock(Stock stock) {
        availableStocks.add(stock);
    }

    public void removeStock(String symbol) {
        for(Iterator<Stock> it = availableStocks.iterator(); it.hasNext();){
            Stock stock = it.next();
            if(stock.getSymbol().equals(symbol)) {
                it.remove();
                break;
            }
        }
    }

    public boolean hasStock(String symbol) {
        for(Iterator<Stock> it = availableStocks.iterator(); it.hasNext();){
            Stock stock = it.next();
            if(stock.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public Stock getAvailableStock(String symbol) {
        for(Iterator<Stock> it = availableStocks.iterator(); it.hasNext();){
            Stock stock = it.next();
            if(stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }

    public void buyStock(Stock stock) {
        boughtStocks.add(stock);
    }

}
