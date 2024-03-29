package com.google.gwt.stockwatcher.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class StockWatcher implements EntryPoint {

    private ClientFactory clientFactory = GWT.create(ClientFactory.class);
    private SimplePanel appWidget = new SimplePanel();

    public void onModuleLoad() {

        RootPanel.get().add(appWidget);

        // Start ActivityManager for the main widget with our ActivityMapper
        clientFactory.getActivityManager().setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        StockWatcherPlaceHistoryMapper historyMapper= GWT.create(StockWatcherPlaceHistoryMapper.class);

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new StockWatcherPlace());

        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();

    }

}
