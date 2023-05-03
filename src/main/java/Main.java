import com.sortly.HdrHistogramFactory;
import com.sortly.IHdrHistogramUtil;

public class Main {
    public static void main(String[] args) {

        HdrHistogramFactory hdrHistogramFactory = new HdrHistogramFactory();

        IHdrHistogramUtil hdrHistogramUtil = hdrHistogramFactory.getHdrHistogram("myservuceName");

        hdrHistogramUtil.recordTime(100);

        hdrHistogramUtil.recordTime(90);
        hdrHistogramUtil.recordTime(200);

        double p50 = hdrHistogramUtil.getPercentile(50);
        double p99 = hdrHistogramUtil.getPercentile(99);
        double p99ForLastPeriodOf100millisecond = hdrHistogramUtil.getPercentileForTimeRange(99,System.currentTimeMillis()-200,
                System.currentTimeMillis()-100);

    }
}