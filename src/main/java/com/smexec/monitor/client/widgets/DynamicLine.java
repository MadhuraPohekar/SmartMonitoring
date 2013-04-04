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
package com.smexec.monitor.client.widgets;

import com.googlecode.gwt.charts.client.ColumnType;

public class DynamicLine
    implements ILineType {

    private int index;
    private String name;
    private String lineColor;
    private ColumnType columnType;

    public DynamicLine(int index, String name, String lineColor, ColumnType columnType) {
        this.index = index;
        this.name = name;
        this.lineColor = lineColor;
        this.columnType = columnType;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getLineColor() {
        return lineColor;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

}
