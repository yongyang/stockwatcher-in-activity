package com.google.gwt.stockwatcher.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StockWatcherServiceAsync {

    void getMessage(String msg, AsyncCallback<String> async);

}
