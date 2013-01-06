package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.ui.LogoView;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 */
public class LogoActivity extends SubActivity {

    protected LogoActivity(ClientFactory clientFactory, Place place, Activity parentActivity) {
        super(clientFactory, place, parentActivity);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final LogoView logoView = getClientFactory().getView(LogoView.class);
        panel.setWidget(logoView.asWidget());
    }

}
