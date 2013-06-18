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
package com.smexec.monitor.server.tasks.impl;

import javax.xml.bind.JAXBException;

import com.smexec.monitor.server.model.DatabaseServer;
import com.smexec.monitor.server.model.ServerStatus;
import com.smexec.monitor.server.model.config.DatabaseConfig;
import com.smexec.monitor.server.model.config.ServerConfig;
import com.smexec.monitor.server.model.config.ServerGroup;
import com.smexec.monitor.server.model.config.ServersConfig;
import com.smexec.monitor.shared.ConnectedServer;

public class ServersConnectorThread
    extends AbstractServersConnectorThread<ServerStatus, ConnectedServer, ServersConfig, DatabaseServer> {

    public ServersConnectorThread()
        throws JAXBException {
        super();
    }

    @Override
    public ServerStatus getServerStatus(ServerConfig sc, final ServerGroup serverGroup) {
        // keeping history stats for 24 hours
        return new ServerStatus(sc, serverGroup, (24 * 60 * 3), (24 * 60 * 3));
    }
    
    @Override
    public DatabaseServer getDatabaseServer(DatabaseConfig dc) {
        return new DatabaseServer(dc);
    }
}