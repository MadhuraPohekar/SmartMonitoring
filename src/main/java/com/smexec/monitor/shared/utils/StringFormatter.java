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
package com.smexec.monitor.shared.utils;


public class StringFormatter {

    public static String formatMillis(long ms) {
        return String.format("%.4fsec", ms / (double) 1000);
    }

    public static String formatMillisShort(long ms) {
        return String.format("%.2fsec", ms / (double) 1000);
    }

    public static String formatBytes(long bytes) {
        long kb = bytes;
        if (bytes > 0) {
            kb = bytes / 1024;
        }
        return kb + "K";
    }

    public static String formatMBytes(long bytes) {
        long kb = bytes;
        if (bytes > 0) {
            kb = bytes / 1024 / 1024;
        }
        return String.valueOf(kb);
    }

}