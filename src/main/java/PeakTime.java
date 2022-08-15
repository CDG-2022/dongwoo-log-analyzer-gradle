import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeakTime {

    private static final int MAX_NUM = 0;
    private String peakTime;
    private List<String> listPeakTimes;
    private LogMap logMap;
    private ResultLog resultLog;

    public PeakTime(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfPeakTime() {
        listPeakTimes = new ArrayList<>(logMap.getTime().keySet());
        listPeakTimes.sort((o1, o2) -> logMap.getTime().get(o2).compareTo(logMap.getTime().get(o1)));
        peakTime = listPeakTimes.get(MAX_NUM);
        resultLog.setResultTimes(Collections.singletonList(peakTime));
    }
}
