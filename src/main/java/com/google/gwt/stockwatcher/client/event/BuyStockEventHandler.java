package com.google.gwt.stockwatcher.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-30
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 */
public interface BuyStockEventHandler extends EventHandler {

    void onBuyStock(BuyStockEvent event);
}
