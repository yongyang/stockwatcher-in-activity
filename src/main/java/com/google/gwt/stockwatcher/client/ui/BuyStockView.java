package com.google.gwt.stockwatcher.client.ui;

import com.google.gwt.stockwatcher.client.activity.BuyStockActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public interface BuyStockView extends IsWidget, ActivityView<BuyStockActivity>{

    AcceptsOneWidget getStatusPanel();

    AcceptsOneWidget getLogoPanel();

}
