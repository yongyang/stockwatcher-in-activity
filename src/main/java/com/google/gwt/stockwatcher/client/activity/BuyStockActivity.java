package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.place.BuyStockPlace;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.BuyStockView;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class BuyStockActivity extends CompositeActivity<BuyStockPlace> {

    private StatusActivity statusActivity;
    private LogoActivity logoActivity;

    public BuyStockActivity(ClientFactory clientFactory, BuyStockPlace place) {
        super(clientFactory, place);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final BuyStockView buyStockView = getClientFactory().getView(BuyStockView.class);
        buyStockView.setActivity(this);
        panel.setWidget(buyStockView.asWidget());

        String symbol = getPlace().getSymbol();
        Stock stock = getClientFactory().getClientSession().getAvailableStock(symbol);
        if(stock != null) {
            buyStockView.updateView(stock);
        }

        // add Sub Activities
        logoActivity = new LogoActivity(getClientFactory(), getPlace(), this);
        statusActivity = new StatusActivity(getClientFactory(), getPlace(), this);
        addSubActivity(buyStockView.getLogoPanel(), logoActivity);
        addSubActivity(buyStockView.getStatusPanel(), statusActivity);
        // super.start will start all Sub activities
        super.start(panel, eventBus);
    }

    @Override
    public String mayStop() {
        return super.mayStop();
    }


    public void buyStock(String symbol) {

    }

    public List<Stock> getAllAvailableStocks() {
        return getClientFactory().getClientSession().getAvailableStocks();
    }

    public boolean hasStock(String symbol) {
        return getClientFactory().getClientSession().hasStock(symbol);
    }
}
