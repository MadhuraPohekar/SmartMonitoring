package com.smexec.monitor.shared;

import java.io.Serializable;
import java.util.LinkedList;

public class FullRefreshResult
    implements Serializable {

    private static final long serialVersionUID = 1L;

    private RefreshResult refreshResult;

    private LinkedList<Alert> alerts;

    public FullRefreshResult() {}

    public FullRefreshResult(RefreshResult refreshResult, LinkedList<Alert> alerts) {
        super();
        this.refreshResult = refreshResult;
        this.alerts = alerts;
    }

    public LinkedList<Alert> getAlerts() {
        return alerts;
    }

    public RefreshResult getRefreshResult() {
        return refreshResult;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FullRefreshResult [refreshResult=").append(refreshResult).append(", alerts=").append(alerts).append("]");
        return builder.toString();
    }

}