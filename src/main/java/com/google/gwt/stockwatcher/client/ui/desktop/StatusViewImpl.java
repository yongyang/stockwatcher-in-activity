package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.stockwatcher.client.ui.StatusView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-27
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
public class StatusViewImpl extends Composite implements StatusView {

    interface BoughtStocksViewImplUiBinder extends UiBinder<FlexTable, StatusViewImpl> {
    }

    private static BoughtStocksViewImplUiBinder uiBinder = GWT.create(BoughtStocksViewImplUiBinder.class);

    FlexTable boughtStocksFlexTable;

    public StatusViewImpl() {
        boughtStocksFlexTable = uiBinder.createAndBindUi(this);
        initWidget(boughtStocksFlexTable);
    }

    @Override
    public void setBoughtStocks(List<Stock> stocks) {
        //TODO: add stocks to boughtStocksFlexTable;
    }
}