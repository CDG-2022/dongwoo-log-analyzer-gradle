package loganalyzer.parsing.sample;

import loganalyzer.LogMap;

import static org.apache.commons.lang3.StringUtils.substringBetween;

public class LogSampler {

    private LogMap logMap;

    private static final int FIRST_PART = 0;
    private static final int SECOND_PART = 1;
    private static final int THIRD_PART = 2;
    private static final int FOURTH_PART = 3;


    public void samplingLog(LogMap logMap, String[] dividedResult) {
        this.logMap = logMap;
        sampleApiKey(dividedResult);
        sampleStateCode(dividedResult);
        sampleServiceId(dividedResult);
        sampleTime(dividedResult);
        sampleBrowser(dividedResult);
    }

    public void sampleApiKey(String[] dividedResult) {
        String sampledApiKey = substringBetween(dividedResult[SECOND_PART], "apikey=", "&");
        logMap.getApiKey().put(sampledApiKey, logMap.getApiKey().getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode(String[] dividedResult) {
        logMap.getStateCode().put(dividedResult[FIRST_PART],
                logMap.getStateCode().getOrDefault(dividedResult[FIRST_PART], 0) + 1);
    }

    public void sampleServiceId(String[] dividedResult) {
        String sampledServiceId = substringBetween(dividedResult[SECOND_PART], "search/", "?");
        logMap.getServiceId().put(sampledServiceId, logMap.getServiceId().getOrDefault(sampledServiceId, 0) + 1);
    }

    public void sampleTime(String[] dividedResult) {
        logMap.getTime().put(dividedResult[FOURTH_PART].substring(0, dividedResult[FOURTH_PART].length()-3),
                logMap.getTime().getOrDefault(dividedResult[FOURTH_PART].substring(0, dividedResult[FOURTH_PART].length()-3), 0) + 1);
    }

    public void sampleBrowser(String[] dividedResult) {
        logMap.getBrowser().put(dividedResult[THIRD_PART], logMap.getBrowser().getOrDefault(dividedResult[THIRD_PART], 0) + 1);
    }
}
