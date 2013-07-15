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
package com.smexec.monitor.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.smexec.monitor.shared.ServerTimeResult;
import com.smexec.monitor.shared.errors.AuthenticationException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("../generalService")
public interface GeneralService
    extends BasicMonitoringService {

    ServerTimeResult refresh()
        throws AuthenticationException;

    Boolean authenticate(String userName, String password);

    String getSettingsXML()
        throws AuthenticationException;

    Boolean saveSettingsXML(String xml)
        throws AuthenticationException;

    void logout();
}