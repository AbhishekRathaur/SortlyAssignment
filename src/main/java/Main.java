import com.sortly.HdrHistogramFactory;
import com.sortly.IHdrHistogramUtil;

public class Main {
    public static void main(String[] args) {

        HdrHistogramFactory hdrHistogramFactory = new HdrHistogramFactory();

        IHdrHistogramUtil hdrHistogramUtil = hdrHistogramFactory.getHdrHistogram("myservuceName");

        hdrHistogramUtil.recordTime(100);

        hdrHistogramUtil.recordTime(100);

    }
}