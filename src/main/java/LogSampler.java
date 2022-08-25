import static org.apache.commons.lang3.StringUtils.substringBetween;

public class LogSampler {

    private LogMap logMap;
    private String apiKey;
    private String stateCode;
    private String serviceId;
    private String Time;
    private String browser;
    private String[] dividedResult;


    public void samplingLog(LogMap logMap, String[] dividedResult) {
        this.logMap = logMap;
        this.dividedResult = dividedResult;
        sampleApiKey();
        sampleStateCode();
        sampleServiceId();
        sampleTime();
        sampleBrowser();
    }

    public void sampleApiKey() {
        String sampledApiKey = substringBetween(dividedResult[1], "apikey=", "&");
        logMap.getApiKey().put(sampledApiKey, logMap.getApiKey().getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode() {
        logMap.getStateCode().put(dividedResult[0], logMap.getStateCode().getOrDefault(dividedResult[0], 0) + 1);
    }

    public void sampleServiceId() {
        String sampledServiceId = substringBetween(dividedResult[1], "search/", "?");
        logMap.getServiceId().put(sampledServiceId, logMap.getServiceId().getOrDefault(sampledServiceId, 0) + 1);
    }

    public void sampleTime() {
        logMap.getTime().put(dividedResult[3].substring(0, dividedResult[3].length()-3),
                logMap.getTime().getOrDefault(dividedResult[3].substring(0, dividedResult[3].length()-3), 0) + 1);
    }

    public void sampleBrowser() {
        logMap.getBrowser().put(dividedResult[2], logMap.getBrowser().getOrDefault(dividedResult[2], 0) + 1);
    }
}
