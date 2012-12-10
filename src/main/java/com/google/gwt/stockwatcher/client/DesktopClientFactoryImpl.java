package com.google.gwt.stockwatcher.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.activity.StockWatcherActivity;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.BuyStockView;
import com.google.gwt.stockwatcher.client.ui.ClientAwareView;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.client.ui.desktop.StockWatcherViewImpl;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class DesktopClientFactoryImpl extends ClientFactory {

    private Map<String, IsWidget> viewMap = new HashMap<String, IsWidget>();

    public <T extends IsWidget> T getView(Class<T> viewClass) {
        if(viewMap.containsKey(viewClass.getName())) {
            return (T)viewMap.get(viewClass.getName());
        }

        IsWidget view = null;

        if(viewClass.equals(StockWatcherView.class)) {
            view = new StockWatcherViewImpl();
        }
        else {

        }
        if(view == null) {
            //TODO:
        }
        if(view instanceof ClientAwareView) {
            ((ClientAwareView)view).setClientFactory(this);
            viewMap.put(viewClass.getName(), view);
        }
        return (T)view;
    }
}
