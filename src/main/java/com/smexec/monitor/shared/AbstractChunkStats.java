package com.smexec.monitor.shared;

import java.io.Serializable;

public abstract class AbstractChunkStats
    implements Serializable {

    private static final long serialVersionUID = 1L;

    private long fullEndTime;
    private long endTime;

    public AbstractChunkStats() {}

    public AbstractChunkStats(long fullEndTime, long endTime) {
        super();
        this.fullEndTime = fullEndTime;
        this.endTime = endTime;
    }

    /**
     * usually to be used for server side, getting delta chunks from connected servers
     * 
     * @return
     */
    public long getFullEndTime() {
        return fullEndTime;
    }

    /**
     * usually for client usage
     * 
     * @return
     */
    public long getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("fet=");
        builder.append(fullEndTime);
        builder.append(", et=");
        builder.append(endTime);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (endTime ^ (endTime >>> 32));
        result = prime * result + (int) (fullEndTime ^ (fullEndTime >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractChunkStats other = (AbstractChunkStats) obj;
        if (endTime != other.endTime)
            return false;
        if (fullEndTime != other.fullEndTime)
            return false;
        return true;
    }

}
