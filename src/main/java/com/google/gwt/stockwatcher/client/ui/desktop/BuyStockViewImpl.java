package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-1
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class BuyStockViewImpl {
    interface BuyStockViewImplUiBinder extends UiBinder<VerticalPanel, BuyStockViewImpl> {
    }

    private static BuyStockViewImplUiBinder ourUiBinder = GWT.create(BuyStockViewImplUiBinder.class);

    public BuyStockViewImpl() {
        VerticalPanel rootElement = ourUiBinder.createAndBindUi(this);

    }
}