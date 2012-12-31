package com.google.gwt.stockwatcher.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.stockwatcher.client.activity.StatusActivity;
import com.google.gwt.stockwatcher.client.activity.StockWatcherActivity;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class ClientFactory implements ActivityMapper {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);

    private final ActivityManager activityManager = new ActivityManager(this, eventBus);

    public EventBus getEventBus() {
        return eventBus;
    }

    public PlaceController getPlaceController() {
        return placeController;
    }

    /**
     * Get View object by Class. Different impl(Desktop/Mobile) can return different View.
     * @param viewClass
     * @param <T>
     * @return
     */
    public abstract <T extends IsWidget> T getView(Class<T> viewClass);

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public Activity getActivity(Place place) {
        if(place instanceof StockWatcherPlace) {
            return new StockWatcherActivity(ClientFactory.this, (StockWatcherPlace)place);
        }
        else {
            return null;
        }
    }

    public ClientSession getClientSession() {
        return ClientSession.getInstance();
    }


}
