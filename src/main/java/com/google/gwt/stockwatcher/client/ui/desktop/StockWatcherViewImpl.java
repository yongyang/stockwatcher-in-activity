package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.place.shared.Place;
import com.google.gwt.stockwatcher.client.activity.PlaceActivity;
import com.google.gwt.stockwatcher.client.activity.StockWatcherActivity;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;

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

    private StockWatcherActivity stockWatcherActivity;

    @UiField
    TextBox stockSymbolTextBox;

    @UiField
    Button addStockButton;

    @UiField
    FlexTable stocksFlexTable;


    @UiField
    FlexTable boughtStocksFlexTable;

    @UiField
    SimplePanel statusPanel;

    @UiField
    SimplePanel logoPanel;


    public StockWatcherViewImpl() {
        VerticalPanel stockWatcherVerticalPanel = stockWatcherViewImplUiBinder.createAndBindUi(this);
        initWidget(stockWatcherVerticalPanel);
        buildStocksTable();
        buildBuyingHistoryTable();
    }

    @Override
    public void setActivity(StockWatcherActivity activity) {
        this.stockWatcherActivity = activity;

        // now init handlers
        addStockButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String stockCode = stockSymbolTextBox.getValue().trim();
                //TODO: validate
                Stock newStock = stockWatcherActivity.addStock(stockCode);
//                addNewRow(newStock);
                refreshStocksFlexTable(stockWatcherActivity.getAllAvailableStocks());
            }
        });
    }

/*
    @Override
    public void onStockAdded(Stock code) {
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
*/

    @Override
    public AcceptsOneWidget getLogoPanel() {
        return logoPanel;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AcceptsOneWidget getStatusPanel() {
        return statusPanel;
    }

    public void toPlace(Place place) {
        ((PlaceActivity) stockWatcherActivity).toPlace(place);
    }

    private void buildBuyingHistoryTable() {
        boughtStocksFlexTable.setText(0, 0, "Symbol");
        boughtStocksFlexTable.setText(0, 1, "Price");
        boughtStocksFlexTable.setText(0, 2, "Count");

        // stocksFlexTable.setCellPadding(6);
        boughtStocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        boughtStocksFlexTable.addStyleName("watchList");
        boughtStocksFlexTable.getCellFormatter().addStyleName(0, 1,
                "watchListNumericColumn");
        boughtStocksFlexTable.getCellFormatter().addStyleName(0, 2,
                "watchListNumericColumn");

    }

    private void buildStocksTable() {
        // Create table for stock data.
        stocksFlexTable.setText(0, 0, "Symbol");
        stocksFlexTable.setText(0, 1, "Price");
        stocksFlexTable.setText(0, 2, "Change");
        stocksFlexTable.setText(0, 3, "Remove");
        stocksFlexTable.setText(0, 4, "Buy");

        // Add styles to elements in the stock list table.
        stocksFlexTable.setCellPadding(6);
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        stocksFlexTable.addStyleName("watchList");
        stocksFlexTable.getCellFormatter().addStyleName(0, 1,
                "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 2,
                "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 3,
                "watchListButtonColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 4,
                "watchListButtonColumn");
    }

    private void addNewRow(Stock stock) {
        String symbol = stock.getSymbol();
        int row = stocksFlexTable.getRowCount();
        stocksFlexTable.setText(row, 0, symbol);
        stocksFlexTable.setWidget(row, 2, new Label());
        stocksFlexTable.getCellFormatter().addStyleName(row, 1,
                "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 2,
                "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 3,
                "watchListRemoveColumn");

        Button removeStockButton = new Button("x");
        removeStockButton.addStyleDependentName("remove");
        stocksFlexTable.setWidget(row, 3, removeStockButton);

        Button buyButton = new Button("$");
        buyButton.addStyleDependentName("Buy");
        stocksFlexTable.setWidget(row, 4, buyButton);

        this.stockSymbolTextBox.setText("");

        updatePrice(row, stock.getPrice());
        updateChangePercent(row, stock.getChange(), stock.getChangePercent());
    }

    private void updatePrice(int row, double value) {
        String priceText = NumberFormat.getFormat("#,##0.00").format(value);
        stocksFlexTable.setText(row, 1, priceText);
    }

    private void updateChangePercent(int row, double change, double changePercent) {
        NumberFormat changeFormat = NumberFormat
                .getFormat("+#,##0.00;-#,##0.00");
        String changeText = changeFormat.format(change);
        String changePercentText = changeFormat.format(changePercent);

        Label changeWidget = (Label) stocksFlexTable.getWidget(row, 2);
        changeWidget.setText(changeText + " (" + changePercentText + "%)");

        String changeStyleName = "noChange";
        if (changePercent < -0.1f) {
            changeStyleName = "negativeChange";
        } else if (changePercent > 0.1f) {
            changeStyleName = "positiveChange";
        }

        changeWidget.setStyleName(changeStyleName);
    }

    private void refreshStocksFlexTable(List<Stock> stocks) {
        int numRows = stocksFlexTable.getRowCount();
        for (int i = 1; i < numRows; i++) {
            stocksFlexTable.removeRow(1);
        }
        for(Stock stock: stocks){
            addNewRow(stock);
        }
    }

}