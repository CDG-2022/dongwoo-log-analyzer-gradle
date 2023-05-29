package loganalyzer.parsing;

import loganalyzer.ResultLog;
import loganalyzer.LogMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxCallApi {

    private static final int MAX_NUM = 0;
    private List<String> listApiKeys;
    private final LogMap logMap;
    private final ResultLog resultLog;

    public MaxCallApi(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfMaxCallApi() {
        listApiKeys = new ArrayList<>(logMap.getApiKey().keySet());
        listApiKeys.sort((o1, o2) -> logMap.getApiKey().get(o2).compareTo(logMap.getApiKey().get(o1)));
        resultLog.setResultApiKeys(Collections.singletonList(listApiKeys.get(MAX_NUM)));
    }

}
