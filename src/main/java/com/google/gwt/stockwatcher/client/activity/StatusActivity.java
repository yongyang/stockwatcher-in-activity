package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.StatusView;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 */
public class StatusActivity extends SubActivity {

    protected StatusActivity(ClientFactory clientFactory, Place place, Activity parentActivity) {
        super(clientFactory, place, parentActivity);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final StatusView statusView = getClientFactory().getView(StatusView.class);
        statusView.setAvailableStocksCount(getClientFactory().getClientSession().getAvailableStocks().size());
        statusView.setBoughtStocksCount(getClientFactory().getClientSession().getBoughtStocks().size());
        panel.setWidget(statusView.asWidget());
    }

}
