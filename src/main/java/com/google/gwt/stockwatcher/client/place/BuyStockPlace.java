package com.google.gwt.stockwatcher.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.stockwatcher.shared.Stock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:33
 * To change this template use File | Settings | File Templates.
 */
public class BuyStockPlace extends Place {

    private String token;
    private Stock stock;

    public BuyStockPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public static class Tokenizer implements PlaceTokenizer<BuyStockPlace> {

        @Override
        public BuyStockPlace getPlace(String token) {
            return new BuyStockPlace(token);
        }

        @Override
        public String getToken(BuyStockPlace place) {
            return place.getToken();
        }
    }
}
