import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PeakTime {

    @Getter
    private String peakTime;
    private List<String> listPeakTimes;
    private LogMap logMap;

    public PeakTime(LogMap logMap) {
        this.logMap = logMap;
    }

    public void logicOfPeakTime() {
        listPeakTimes = new ArrayList<>(logMap.getTime().keySet());
        listPeakTimes.sort((o1, o2) -> logMap.getTime().get(o2).compareTo(logMap.getTime().get(o1)));
        peakTime = listPeakTimes.get(0);
    }
}
