package com.sortly;

import java.util.HashMap;
import java.util.Map;

public class HdrHistogramFactory {
    Map<String, IHdrHistogramUtil> hdrHistogramUtilMap ;

    public HdrHistogramFactory(){
        this.hdrHistogramUtilMap = new HashMap<>();
    }

    public IHdrHistogramUtil getHdrHistogram(String serviceName){
        if(hdrHistogramUtilMap.containsKey(serviceName))
            return hdrHistogramUtilMap.get(serviceName);
        else {
            IHdrHistogramUtil iHdrHistogramUtil = new HdrHistogramUtilImpl();
            hdrHistogramUtilMap.put(serviceName, iHdrHistogramUtil);
            return iHdrHistogramUtil;
        }

    }
}
