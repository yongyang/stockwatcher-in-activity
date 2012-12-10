package com.google.gwt.stockwatcher.server;

import com.google.gwt.stockwatcher.client.StockWatcherService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StockWatcherServiceImpl extends RemoteServiceServlet implements StockWatcherService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}