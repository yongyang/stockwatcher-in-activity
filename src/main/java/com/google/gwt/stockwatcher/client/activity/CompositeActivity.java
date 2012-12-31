package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-31
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompositeActivity extends PlaceActivity {

    private Map<AcceptsOneWidget,SubActivity> subActivities = new HashMap<AcceptsOneWidget, SubActivity>();

    public CompositeActivity(ClientFactory clientFactory, Place place) {
        super(clientFactory, place);
    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        // start Sub Activities.
        startSubActivities(subActivities, eventBus);
    }

    /**
     * start Sub Activities.
     * Make sure this method be called after CompositeActivity inited
     * @param subActivities
     * @param eventBus
     */
    protected void startSubActivities(Map<AcceptsOneWidget,SubActivity> subActivities, EventBus eventBus) {
        for(Iterator<Map.Entry<AcceptsOneWidget, SubActivity>> it = subActivities.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<AcceptsOneWidget, SubActivity> entry = it.next();
            entry.getValue().start(entry.getKey(), eventBus);
        }

    }

    @Override
    public String mayStop() {
        mayStopSubActivities();
        return super.mayStop();
    }

    /**
     * call in mayStop
     */
    protected void mayStopSubActivities() {
        for(SubActivity subActivity : subActivities.values()){
            subActivity.mayStop();
        }
    }

    protected void addSubActivity(AcceptsOneWidget subPanel, SubActivity subActivity) {
        subActivities.put(subPanel, subActivity);
    }

}
