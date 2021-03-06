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
package org.clevermore.monitor.client;

import org.clevermore.monitor.shared.alert.RefreshAlertsRequest;
import org.clevermore.monitor.shared.alert.RefreshAlertsResponse;
import org.clevermore.monitor.shared.errors.AuthenticationException;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("../alertsService")
public interface AlertsService
    extends BasicMonitoringRefreshService<RefreshAlertsRequest, RefreshAlertsResponse> {

    Boolean stopAlerts(boolean enable) throws AuthenticationException;

}
