package com.sortly;

public interface IHdrHistogramUtil {
    void recordTime(int requestTimeinMilliseconds);

    double getPercentile(long percent);

    double getPercentileForTimeRange(int percent, long startTime, long endTime);
}
