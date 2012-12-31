package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;

/**
 * Sub Activity is a kind of Activity instantiated by its parent Activity
 * Sub Activity responsible for init the display area which is managed by it.
 */
public abstract class SubActivity extends PlaceActivity {

    private Activity parentActivity;

    protected SubActivity(ClientFactory clientFactory, Place place, Activity parentActivity ) {
        super(clientFactory, place);
        this.parentActivity = parentActivity;
    }

    public Activity getParentActivity() {
        return parentActivity;
    }
}
