package loganalyzer.parsing.sample;

import loganalyzer.LogMap;

import static org.apache.commons.lang3.StringUtils.substringBetween;

public class LogSampler {

    private LogMap logMap;

    private static final int INDEX_STATE_CODE = 0;
    private static final int INDEX_URL = 1;
    private static final int INDEX_BROWSER = 2;
    private static final int INDEX_DATE = 3;
    
    public void samplingLog(LogMap logMap, String[] dividedResult) {
        this.logMap = logMap;
        sampleApiKey(dividedResult);
        sampleStateCode(dividedResult);
        sampleServiceId(dividedResult);
        sampleTime(dividedResult);
        sampleBrowser(dividedResult);
    }

    public void sampleApiKey(String[] dividedResult) {
        String sampledApiKey = substringBetween(dividedResult[INDEX_URL], "apikey=", "&");
        logMap.getApiKey().put(sampledApiKey, logMap.getApiKey().getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode(String[] dividedResult) {
        logMap.getStateCode().put(dividedResult[INDEX_STATE_CODE],
                logMap.getStateCode().getOrDefault(dividedResult[INDEX_STATE_CODE], 0) + 1);
    }

    public void sampleServiceId(String[] dividedResult) {
        String sampledServiceId = substringBetween(dividedResult[INDEX_URL], "search/", "?");
        logMap.getServiceId().put(sampledServiceId, logMap.getServiceId().getOrDefault(sampledServiceId, 0) + 1);
    }

    public void sampleTime(String[] dividedResult) {
        logMap.getTime().put(dividedResult[INDEX_DATE].substring(0, dividedResult[INDEX_DATE].length()-3),
                logMap.getTime().getOrDefault(dividedResult[INDEX_DATE].substring(0, dividedResult[INDEX_DATE].length()-3), 0) + 1);
    }

    public void sampleBrowser(String[] dividedResult) {
        logMap.getBrowser().put(dividedResult[INDEX_BROWSER], logMap.getBrowser().getOrDefault(dividedResult[INDEX_BROWSER], 0) + 1);
    }
}
