package com.google.gwt.stockwatcher.client.ui.mobile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-1
 * Time: 上午2:00
 * To change this template use File | Settings | File Templates.
 */
public class StockWatcherViewImpl {
    interface StockWatcherViewImplUiBinder extends UiBinder<VerticalPanel, StockWatcherViewImpl> {
    }

    private static StockWatcherViewImplUiBinder ourUiBinder = GWT.create(StockWatcherViewImplUiBinder.class);

    public StockWatcherViewImpl() {
        VerticalPanel rootElement = ourUiBinder.createAndBindUi(this);

    }
}