package com.smexec.monitor.shared;

import java.io.Serializable;
import java.util.Arrays;

public class GCHistory
    implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collectorName;

    private long collectionCount;

    /**
     * total collection time spent by this pool
     */
    private long collectionTime;

    private long lastColleactionTime;

    private String[] memoryPoolNames;

    public GCHistory() {}

    public GCHistory(String collectorName, long collectionCount, long collectionTime, String[] memoryPoolNames) {
        super();
        this.collectorName = collectorName;
        this.collectionCount = collectionCount;
        this.collectionTime = collectionTime;
        this.memoryPoolNames = memoryPoolNames;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public long getCollectionCount() {
        return collectionCount;
    }

    public long getCollectionTime() {
        return collectionTime;
    }

    public String[] getMemoryPoolNames() {
        return memoryPoolNames;
    }

    public long getLastColleactionTime() {
        return lastColleactionTime;
    }

    public void setLastColleactionTime(long lastColleactionTime) {
        this.lastColleactionTime = lastColleactionTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (collectionCount ^ (collectionCount >>> 32));
        result = prime * result + (int) (collectionTime ^ (collectionTime >>> 32));
        result = prime * result + ((collectorName == null) ? 0 : collectorName.hashCode());
        result = prime * result + (int) (lastColleactionTime ^ (lastColleactionTime >>> 32));
        result = prime * result + Arrays.hashCode(memoryPoolNames);
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
        GCHistory other = (GCHistory) obj;
        if (collectionCount != other.collectionCount)
            return false;
        if (collectionTime != other.collectionTime)
            return false;
        if (collectorName == null) {
            if (other.collectorName != null)
                return false;
        } else if (!collectorName.equals(other.collectorName))
            return false;
        if (lastColleactionTime != other.lastColleactionTime)
            return false;
        if (!Arrays.equals(memoryPoolNames, other.memoryPoolNames))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GCHistory [collectorName=");
        builder.append(collectorName);
        builder.append(", collectionCount=");
        builder.append(collectionCount);
        builder.append(", collectionTime=");
        builder.append(collectionTime);
        builder.append(", lastColleactionTime=");
        builder.append(lastColleactionTime);
        builder.append(", memoryPoolNames=");
        builder.append(Arrays.toString(memoryPoolNames));
        builder.append("]");
        return builder.toString();
    }

}
