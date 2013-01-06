package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.stockwatcher.client.activity.BuyStockActivity;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.BuyStockView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-1
 * Time: 下午10:15
 * To change this template use File | Settings | File Templates.
 */
public class BuyStockViewImpl extends Composite implements BuyStockView {
    interface BuyStockViewImplUiBinder extends UiBinder<VerticalPanel, BuyStockViewImpl> {
    }

    private static BuyStockViewImplUiBinder ourUiBinder = GWT.create(BuyStockViewImplUiBinder.class);

    private BuyStockActivity buyStockActivity;

    @UiField
    TextBox symbol;
    @UiField
    TextBox price;
    @UiField
    TextBox amount;
    @UiField
    Button saveButton;
    @UiField
    Button cancelButton;

    @UiField
    SimplePanel logoPanel;

    @UiField
    SimplePanel statusPanel;

    public BuyStockViewImpl() {
        VerticalPanel verticalPanel = ourUiBinder.createAndBindUi(this);
        initWidget(verticalPanel);
    }

    public void updateView(Stock stock){
        symbol.setText(stock.getSymbol());
        price.setText(stock.getPrice() + "");
    }

    public SimplePanel getLogoPanel() {
        return logoPanel;
    }

    public SimplePanel getStatusPanel() {
        return statusPanel;
    }

    public void setActivity(BuyStockActivity _buyStockActivity) {
        this.buyStockActivity = _buyStockActivity;

        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                buyStockActivity.toPlace(new StockWatcherPlace());
            }
        });
    }
}