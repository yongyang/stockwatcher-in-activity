package com.google.gwt.stockwatcher.client.ui.desktop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.stockwatcher.client.ui.LogoView;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created with IntelliJ IDEA.
 * User: yyang
 * Date: 12-12-31
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
public class LogoViewImpl extends Composite implements LogoView{

    interface LogoViewImplUiBinder extends UiBinder<HTMLPanel, LogoViewImpl> {
    }

    private static LogoViewImplUiBinder ourUiBinder = GWT.create(LogoViewImplUiBinder.class);

    public LogoViewImpl() {
        HTMLPanel htmlPanel = ourUiBinder.createAndBindUi(this);
        initWidget(htmlPanel);
    }
}