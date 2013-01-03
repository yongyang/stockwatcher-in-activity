package com.google.gwt.stockwatcher.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.stockwatcher.client.ClientFactory;
import com.google.gwt.stockwatcher.client.place.StockWatcherPlace;
import com.google.gwt.stockwatcher.client.ui.StockWatcherView;
import com.google.gwt.stockwatcher.shared.Stock;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class StockWatcherActivity extends CompositeActivity {

    private StatusActivity statusActivity;
    private LogoActivity logoActivity;

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
        logoActivity = new LogoActivity(getClientFactory(), getPlace(), this);
        statusActivity = new StatusActivity(getClientFactory(), getPlace(), this);
        addSubActivity(stockWatcherView.getLogoPanel(), logoActivity);
        addSubActivity(stockWatcherView.getStatusPanel(), statusActivity);
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

    public Stock addStock(String symbol) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Stock>> violations = validator.validate(stock);
        if(!violations.isEmpty()) {
            throw new ValidationException(violations.iterator().next().getMessage());
        }

        //TODO: validate
        //TODO: existed check
        getClientFactory().getClientSession().addStock(stock);
        // update status panel
        statusActivity.updateStatus();
        return stock;
    }

    public void removeStock(String symbol) {
        getClientFactory().getClientSession().removeStock(symbol);
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
