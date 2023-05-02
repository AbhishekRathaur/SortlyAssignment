package com.sortly;

import org.HdrHistogram.Histogram;

public class HdrHistogramUtilImpl implements IHdrHistogramUtil{

    private Histogram histogram ;


    HdrHistogramUtilImpl(){
        //This creates a histogram that can track values from 1 millisecond to 1 hour with a resolution of 2
        this.histogram = new Histogram(1, 3600000, 2);
    }
    @Override
    public void recordTime(int requestTimeinMilliseconds) {
        histogram.recordValue(requestTimeinMilliseconds);
    }

    @Override
    public double getPercentile(long percentage) {
        return histogram.getPercentileAtOrBelowValue(percentage);
    }

    @Override
    public double getPercentileForTimeRange(int percent, long startTime, long endTime){
        Histogram filteredHistogram = histogram.copy();
        filteredHistogram.setStartTimeStamp(startTime);
        filteredHistogram.setEndTimeStamp(endTime);
        double percentile = filteredHistogram.getPercentileAtOrBelowValue(50);
        return percentile;
    }
}
