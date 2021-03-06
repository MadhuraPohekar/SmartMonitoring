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
package org.clevermore.monitor.server.tasks.impl;

import java.util.Date;

import org.clevermore.monitor.server.model.DatabaseServer;
import org.clevermore.monitor.server.model.ServerStatus;
import org.clevermore.monitor.server.model.config.ServerConfig;
import org.clevermore.monitor.server.tasks.AbstractDbRefresher;
import org.clevermore.monitor.server.tasks.AbstractRefresher;
import org.clevermore.monitor.server.tasks.AbstractStateUpdaterThread;
import org.clevermore.monitor.shared.runtime.MemoryUsageLight;
import org.clevermore.monitor.shared.servers.ConnectedServer;


public class StateUpdaterThread
    extends AbstractStateUpdaterThread<ServerStatus, AbstractRefresher<ServerStatus>, DatabaseServer> {

    @Override
    public AbstractRefresher<ServerStatus> getRefresher(ServerStatus ss, Date executionDate, int excutionNumber) {
        return new StandardRefresher(ss, executionDate, excutionNumber);
    }

    @Override
    public AbstractDbRefresher<DatabaseServer> getDbRefresher(DatabaseServer ds) {
        return new StandardDbRefresher(ds);
    }

    @Override
    public ConnectedServer getConnectedServer(ServerStatus ss) {
        ServerConfig sc = ss.getServerConfig();

        MemoryUsageLight mul = getMemoryLight(ss);

        return new ConnectedServer(sc.getName(),
                                   sc.getServerCode(),
                                   sc.getIp(),
                                   sc.getJmxPort(),
                                   ss.isConnected(),
                                   mul,
                                   ss.getHighHistory(),
                                   ss.getUpTime(),
                                   ss.getCpuUtilization().getLastPercent().getUsage(),
                                   ss.getCpuUtilization().getLastPercent().getSystemLoadAverage());
    }

}
