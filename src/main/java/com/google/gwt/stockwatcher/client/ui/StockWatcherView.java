package com.google.gwt.stockwatcher.client.ui;

import com.google.gwt.stockwatcher.client.activity.StockWatcherActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * View负责初始化静态的视图。
 * 所有动态视图的展现都应该由 Activity 来控制
 */
public interface StockWatcherView extends IsWidget, ActivityView<StockWatcherActivity> {

    AcceptsOneWidget getStatusPanel();

    AcceptsOneWidget getLogoPanel();

}
