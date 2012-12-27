package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午11:23
 * To change this template use File | Settings | File Templates.
 */
class StockWatcherViewImpl extends Composite implements StockWatcherView{

    @UiTemplate("StockWatcherViewImpl.ui.xml")
    interface StockWatcherViewImplUiBinder extends UiBinder<VerticalPanel, StockWatcherViewImpl> {
    }
    private static StockWatcherViewImplUiBinder stockWatcherViewImplUiBinder = GWT.create(StockWatcherViewImplUiBinder.class);

    private ClientFactory clientFactory;

    @UiField
    FlexTable stocksFlexTable;

/*
    @UiField
    FlexTable boughtStocksFlexTable;
*/

    @UiField
    SimplePanel statusPanel;

    public StockWatcherViewImpl() {
        VerticalPanel stockWatcherVerticalPanel = stockWatcherViewImplUiBinder.createAndBindUi(this);
        initWidget(stockWatcherVerticalPanel);
    }

    @Override
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void addStock(String code) {
        //To change body of implemented methods use File | Settings | File Templates.

        Button buyButton = new Button("Buy");
        buyButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                ClientFactory.fireEvent(new BuyStockEvent(null));
//                eventBus.fireEvent(new BuyStockEvent(null));
            }
        });
    }

    public AcceptsOneWidget getStatusPanel() {
        return statusPanel;
    }

    @Override
    public void removeStock(String code) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addBoughtStock() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void toPlace(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}