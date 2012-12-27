package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.StatusView;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 */
public class BoughtStocksActivity extends PlaceActivity<StockWatcherPlace> {

    public BoughtStocksActivity(ClientFactory clientFactory, StockWatcherPlace place) {
        super(clientFactory, place);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final StatusView statusView = getClientFactory().getView(StatusView.class);
        panel.setWidget(statusView.asWidget());
    }

}
