package com.smexec.monitor.client.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.smexec.monitor.client.utils.ClientStringFormatter;
import com.smexec.monitor.client.widgets.AbstractMonitoringWidget;
import com.smexec.monitor.client.widgets.LineType;
import com.smexec.monitor.client.widgets.MonitoringLineChart;
import com.smexec.monitor.shared.ChannelChunkStats;
import com.smexec.monitor.shared.ChannelSeverStats;
import com.smexec.monitor.shared.ChartFeed;

public class PlayersWidget
    extends AbstractMonitoringWidget {

    private FlowPanel fp = new FlowPanel();
    private MonitoringLineChart connected = new MonitoringLineChart(new LineType[] {LineType.CONNECTED, LineType.PLAYING}, "Players", "Time", "Online Players");
    private MonitoringLineChart reconnected = new MonitoringLineChart(new LineType[] {LineType.DROPPED, LineType.OPENED}, "Players", "Time", "Drops vs. New");
    private FlexTable playersTable = new FlexTable();

    public PlayersWidget() {
        super("Online Players");
        addStyleName("playersWidget");
        getScrollPanel().add(fp);

        FlowPanel players = getPlayers();
        FlowPanel charts = getCharts();
        FlowPanel servers = getServers();
        fp.add(players);
        fp.add(charts);
        fp.add(servers);
    }

    public void update(ChannelSeverStats css) {
        int i = 0;
        Log.debug("Players:" + css);
        ChannelChunkStats lastChunk = css.getLastChunk();
        Log.debug("Last Chunk:" + lastChunk);
        playersTable.setText(i++, 1, ClientStringFormatter.formatNumber(css.getOpenBinarySessions() + css.getOpenStringSessions()));
        playersTable.setText(i++, 1, ClientStringFormatter.formatNumber(lastChunk.getPlaying()));
        playersTable.setText(i++, 1, ClientStringFormatter.formatNumber(lastChunk.getDisconnectedBinarySessions() + lastChunk.getDisconnectedLegacySessions()));
        playersTable.setText(i++, 1, ClientStringFormatter.formatNumber(lastChunk.getConnectedBinarySessions() + lastChunk.getConnectedLegacySessions()));

        playersTable.setText(i++, 1,"-1");
        playersTable.setText(i++, 1,"-1");
        playersTable.setText(i++, 1,"-1");
        playersTable.setText(i++, 1,"-1");
        playersTable.setText(i++, 1,"-1");
        playersTable.setText(i++, 1,"-1");

        ArrayList<ChannelChunkStats> values = new ArrayList<ChannelChunkStats>(css.getMapValues());
        Collections.sort(values, new Comparator<ChannelChunkStats>() {

            @Override
            public int compare(ChannelChunkStats o1, ChannelChunkStats o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });
        updateOnlinePlayers(css, values);
        updatedropsAndConnections(css, values);

    }

    private void updatedropsAndConnections(ChannelSeverStats css, ArrayList<ChannelChunkStats> values) {
        ChartFeed dropsAndConnections = new ChartFeed(values.size(), 3);
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < values.size(); j++) {
                if (k == 0) {
                    // drops
                    dropsAndConnections.getValues()[k][j] = values.get(j).getDisconnectedBinarySessions() + values.get(j).getDisconnectedLegacySessions();
                } else if (k == 1) {
                    // new connetions
                    dropsAndConnections.getValues()[k][j] = values.get(j).getConnectedBinarySessions() + values.get(j).getConnectedLegacySessions();
                } else if (k == 2) {
                    dropsAndConnections.getValues()[k][j] = values.get(j).getStartTimeForChart();
                }
            }
        }

        Log.debug("Updating drops, values size:" + values.size());
        reconnected.updateChart(dropsAndConnections, true);
    }

    private void updateOnlinePlayers(ChannelSeverStats css, ArrayList<ChannelChunkStats> values) {
        ChartFeed online = new ChartFeed(values.size(), 3);
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < values.size(); j++) {
                if (k == 0) {
                    // connected
                    online.getValues()[k][j] = values.get(j).getOpenBinarySessions() + values.get(j).getOpenStringSessions();
                } else if (k == 1) {
                    // playing
                    online.getValues()[k][j] = values.get(j).getPlaying();
                } else if (k == 2) {
                    online.getValues()[k][j] = values.get(j).getStartTimeForChart();
                }
            }
        }
        Log.debug("Updating connected, values size:" + values.size());

        connected.updateChart(online, true);
    }

    private FlowPanel getServers() {
        FlowPanel fp = new FlowPanel();
        fp.setStyleName("servers");
        return fp;
    }

    private FlowPanel getCharts() {
        FlowPanel fp = new FlowPanel();
        fp.setStyleName("charts");
        fp.add(connected);
        fp.add(reconnected);
        connected.setStyleName("playersChart");
        reconnected.setStyleName("reconnectionsChart");

        return fp;
    }

    private FlowPanel getPlayers() {

        FlowPanel fp = new FlowPanel();
        fp.setStyleName("players");

        playersTable.getElement().setId("infoTable");
        fp.add(playersTable);

        int i = 0;
        playersTable.setText(i++, 0, "Connected:");
        playersTable.setText(i++, 0, "Playing:");
        playersTable.setText(i++, 0, "Disconnected (last min)");
        playersTable.setText(i++, 0, "Connected (last min)");

        playersTable.setText(i++, 0, "Real Tables");
        playersTable.setText(i++, 0, "Fun Table");
        playersTable.setText(i++, 0, "Real Players");
        playersTable.setText(i++, 0, "Fun Player");

        playersTable.setText(i++, 0, "Speed Poker Rooms");
        playersTable.setText(i++, 0, "Speed Poker Players");

        return fp;
    }

}
