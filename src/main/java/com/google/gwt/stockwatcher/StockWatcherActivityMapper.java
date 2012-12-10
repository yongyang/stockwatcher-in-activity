package com.google.gwt.stockwatcher;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
public class StockWatcherActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public StockWatcherActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        return null;
    }
}
