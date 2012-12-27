package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.stockwatcher.client.ui.StatusView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-27
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
public class StatusViewImpl extends Composite implements StatusView {

    interface StatusViewImplUiBinder extends UiBinder<HorizontalPanel, StatusViewImpl> {
    }

    private static StatusViewImplUiBinder uiBinder = GWT.create(StatusViewImplUiBinder.class);

    HorizontalPanel horizontalPanel;

    public StatusViewImpl() {
        horizontalPanel = uiBinder.createAndBindUi(this);
        initWidget(horizontalPanel);
    }

    @Override
    public void setBoughtStocks(List<Stock> stocks) {
        //TODO: add stocks to boughtStocksFlexTable;
    }
}