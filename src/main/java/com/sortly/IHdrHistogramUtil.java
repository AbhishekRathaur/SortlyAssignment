package com.sortly;

public interface IHdrHistogramUtil {
    void recordTime(int requestTimeinMilliseconds);

    double getPercentile(long percent);

    double getPercentileForTimeRange(int percent, long startTimestamp, long endTimestamp);
}
