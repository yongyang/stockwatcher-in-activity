package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-31
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompositeActivity extends PlaceActivity {

    public CompositeActivity(ClientFactory clientFactory, Place place) {
        super(clientFactory, place);
    }

    /**
     * start Sub Activities.
     * Make sure this method be called after CompositeActivity inited
     * @param panels
     * @param subActivities
     * @param eventBus
     */
    protected void startSubActivities(AcceptsOneWidget[] panels, SubActivity[] subActivities, EventBus eventBus) {
        for(int i=0; i<subActivities.length; i++){
            subActivities[i].start(panels[i], eventBus);
        }
    }

    @Override
    public String mayStop() {
        for(SubActivity subActivity : getSubActivities()){
            subActivity.mayStop();
        }
        return super.mayStop();
    }

    abstract SubActivity[] getSubActivities();
}
