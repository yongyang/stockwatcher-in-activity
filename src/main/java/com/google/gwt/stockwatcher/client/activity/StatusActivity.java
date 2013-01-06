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

    private StatusView statusView = null;

    protected StatusActivity(ClientFactory clientFactory, Place place, Activity parentActivity) {
        super(clientFactory, place, parentActivity);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        statusView = getClientFactory().getView(StatusView.class);
        panel.setWidget(statusView.asWidget());
        // update status on init
        updateStatus();
    }

    public void updateStatus() {
        statusView.setAvailableStocksCount(getClientFactory().getClientSession().getAvailableStockCount());
        statusView.setBoughtStocksCount(getClientFactory().getClientSession().getBoughtStockCount());
    }
}
