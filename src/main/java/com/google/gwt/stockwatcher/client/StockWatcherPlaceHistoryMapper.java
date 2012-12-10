package com.google.gwt.stockwatcher.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.google.gwt.stockwatcher.client.place.BuyStockPlace;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午6:44
 * To change this template use File | Settings | File Templates.
 */

@WithTokenizers({StockWatcherPlace.class, BuyStockPlace.Tokenizer.class})
public interface StockWatcherPlaceHistoryMapper extends PlaceHistoryMapper{
}
