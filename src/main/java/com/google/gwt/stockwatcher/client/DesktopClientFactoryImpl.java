package com.google.gwt.stockwatcher.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.activity.StockWatcherActivity;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.BuyStockView;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.client.ui.desktop.StockWatcherViewImpl;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class DesktopClientFactoryImpl extends ClientFactory {
    private final StockWatcherView stockWatcherView = new StockWatcherViewImpl();
    private final BuyStockView buyStockView = null;

    @Override
    public StockWatcherView getStockWatcherView() {
        return stockWatcherView;
    }

    @Override
    public BuyStockView getBuyStockView() {
        return buyStockView;
    }
}
