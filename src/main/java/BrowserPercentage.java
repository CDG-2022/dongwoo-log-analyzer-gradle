import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrowserPercentage {

    @Getter
    private Map<String, Double> browserPercentage = new HashMap<>();
    private List<String> listBrowserPercentages;
    private LogMap logMap;
    private ResultLog resultLog;

    public BrowserPercentage(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfBrowserPercentage() {

        listBrowserPercentages = new ArrayList<>(logMap.getBrowser().keySet());
        listBrowserPercentages.sort((o1, o2) -> logMap.getBrowser().get(o2).compareTo(logMap.getBrowser().get(o1)));
        int total = 0;
        for(int i = 0; i < listBrowserPercentages.size(); i++) {
            total += logMap.getBrowser().get(listBrowserPercentages.get(i));
        }

        for(int i = 0; i < listBrowserPercentages.size(); i++) {
            browserPercentage.put(listBrowserPercentages.get(i),
                    (double)logMap.getBrowser().get(listBrowserPercentages.get(i))/total*100);
        }

        resultLog.setResultBrowsers(browserPercentage);

    }
}
