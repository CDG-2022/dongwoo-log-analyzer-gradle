package loganalyzer.parsing;

import loganalyzer.LogMap;
import loganalyzer.ResultLog;

public class StateCodePerCount {

    private final LogMap logMap;
    private final ResultLog resultLog;

    public StateCodePerCount(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfStateCodePerCount() {
        resultLog.setResultStateCodes(logMap.getStateCode());
    }
}
