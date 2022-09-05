package loganalyzer.parsing;

import loganalyzer.LogMap;
import loganalyzer.ResultLog;

import java.util.*;

public class BrowserPercentage {

    private final LogMap logMap;
    private final ResultLog resultLog;

    public BrowserPercentage(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfBrowserPercentage() {

        Map<String, Double> browserPercentage = new HashMap<>();
        List<String> listBrowserPercentages;

        listBrowserPercentages = new ArrayList<>(logMap.getBrowser().keySet());
        Collections.sort(listBrowserPercentages);
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
