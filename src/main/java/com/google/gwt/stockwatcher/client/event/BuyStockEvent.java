package com.google.gwt.stockwatcher.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.stockwatcher.shared.Stock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午8:52
 * To change this template use File | Settings | File Templates.
 */
public class BuyStockEvent extends GwtEvent<BuyStockEventHandler> {

    public static Type<BuyStockEventHandler> TYPE = new Type<BuyStockEventHandler>();

    private Stock stock;

    public BuyStockEvent(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public Type<BuyStockEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BuyStockEventHandler handler) {
        handler.onBuyStock(this);
    }
}
