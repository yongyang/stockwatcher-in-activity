package com.google.gwt.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class StockWatcher implements EntryPoint {

    private ClientFactory clientFactory = GWT.create(ClientFactory.class);
    private SimplePanel appWidget = new SimplePanel();

    public void onModuleLoad() {

        RootPanel.get("stockList").add(appWidget);

        // Start ActivityManager for the main widget with our ActivityMapper
        clientFactory.getMainActivityManager().setDisplay(appWidget);

        // call statusActivityManager.setDisplay so that register it to eventBus
        clientFactory.getStatusActivityManager().setDisplay(new SimplePanel());

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        StockWatcherPlaceHistoryMapper historyMapper= GWT.create(StockWatcherPlaceHistoryMapper.class);

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new StockWatcherPlace());

        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();

    }

}
