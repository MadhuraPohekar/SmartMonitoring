/**
 * Copyright (C) 2013 Arman Gal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.clevermore.monitor.shared.alert;

import org.clevermore.monitor.client.AbstractRefreshRequest;

public class RefreshAlertsRequest
    extends AbstractRefreshRequest {

    private static final long serialVersionUID = 1L;

    private int lastAlertId;

    public RefreshAlertsRequest() {}

    public RefreshAlertsRequest(int lastAlertId) {
        super();
        this.lastAlertId = lastAlertId;
    }

    public int getLastAlertId() {
        return lastAlertId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RefreshAlertsRequest [lastAlertId=").append(lastAlertId).append("]");
        return builder.toString();
    }

}
