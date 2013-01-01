package com.google.gwt.stockwatcher.client.ui;

import com.google.gwt.activity.shared.Activity;

/**
 * Views which has a Activity reference
 */
public interface ActivityView<T extends Activity> {

    void setActivity(T activity);

}
