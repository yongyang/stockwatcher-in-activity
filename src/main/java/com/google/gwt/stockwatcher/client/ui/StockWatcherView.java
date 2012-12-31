package com.google.gwt.stockwatcher.client.ui;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;

/**
 * View负责初始化静态的视图。
 * 所有动态视图的展现都应该由 Activity 来控制
 */
public interface StockWatcherView extends IsWidget, ClientAware {

    void onStockAdded(Stock code);
    void removeStock(String code);

    void addBoughtStock();

    void addClickHandlerOfAddStockButton(ClickHandler clickHandler);
    String getAddStockValue();

    AcceptsOneWidget getStatusPanel();

    AcceptsOneWidget getLogoPanel();

}
