package com.google.gwt.stockwatcher.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:16
 * To change this template use File | Settings | File Templates.
 */
public class StockWatcherPlace extends Place {

    @Prefix("stocks")
    public static class Tokenizer implements PlaceTokenizer<StockWatcherPlace> {

        @Override
        public StockWatcherPlace getPlace(String token) {
            return new StockWatcherPlace();
        }

        @Override
        public String getToken(StockWatcherPlace place) {
            return "";
        }
    }
}

