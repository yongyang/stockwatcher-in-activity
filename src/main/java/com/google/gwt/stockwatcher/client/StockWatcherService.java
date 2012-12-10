package com.google.gwt.stockwatcher.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("StockWatcherService")
public interface StockWatcherService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);



    /**
     * Utility/Convenience class.
     * Use StockWatcherService.Async.getInstance() to access static instance of SotckWatcherServiceAsync
     */
    public static class Async {

        private static StockWatcherServiceAsync instance = GWT.create(StockWatcherService.class);

        public static synchronized StockWatcherServiceAsync getInstance() {
            return instance;
        }
    }

}
