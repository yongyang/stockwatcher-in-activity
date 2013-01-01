package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.ActivityView;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 */
public class StockWatcherActivity extends CompositeActivity {

    public StockWatcherActivity(ClientFactory clientFactory, StockWatcherPlace place) {
        super(clientFactory, place);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final StockWatcherView stockWatcherView = getClientFactory().getView(StockWatcherView.class);
        stockWatcherView.setActivity(this);

        panel.setWidget(stockWatcherView.asWidget());

        // init handlers
/*
        stockWatcherView.addClickHandlerOfAddStockButton(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String stockCode = stockWatcherView.getAddStockValue();
                Stock stock = new Stock();
                getClientFactory().getClientSession().addStock(stock);
                stockWatcherView.onStockAdded(stock);
            }
        });
*/

        // add Sub Activities
        addSubActivity(stockWatcherView.getLogoPanel(), new LogoActivity(getClientFactory(), getPlace(), this));
        addSubActivity(stockWatcherView.getStatusPanel(), new StatusActivity(getClientFactory(), getPlace(), this));
        // super.start will start all Sub activities
        super.start(panel, eventBus);
    }

    @Override
    public String mayStop() {
        super.mayStop();
        //IMPORTANT!!! setDisplay null to remove handlers from eventBus
//        getClientFactory().getStatusActivityManager().setDisplay(null);
        return "Please hold on. Activity " + this.getClass().getName() + " is stopping.";
    }

}
