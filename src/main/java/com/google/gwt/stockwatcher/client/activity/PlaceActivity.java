package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;

/**
 * 统一注入 ClientFactory, Place
 * 并实现 toPlace
 *
 * 负责 View 的初始化，以及页面逻辑，如打开窗口，View上数据的动态增删
 *
 * 注意：所有与View具体实现逻辑相关的代码都不应在Activity中
 */
public abstract class PlaceActivity<P extends Place> extends AbstractActivity{

    private ClientFactory clientFactory;
    private P place;

    protected PlaceActivity(ClientFactory clientFactory, P place) {
        this.clientFactory = clientFactory;
        this.place = place;
    }

    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    public P getPlace() {
        return place;
    }

    public void toPlace(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
