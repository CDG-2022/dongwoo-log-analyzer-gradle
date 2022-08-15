public class StateCodePerCount {

    private LogMap logMap;
    private ResultLog resultLog;

    public StateCodePerCount(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfStateCodePerCount() {
        resultLog.setResultStateCodes(logMap.getStateCode());
    }
}
