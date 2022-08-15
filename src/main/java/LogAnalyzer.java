import lombok.Getter;

import java.io.IOException;

public class LogAnalyzer {

    @Getter
    private String lineOfLog;
    private final LogFileReader logFileReader;
    private final LogMap logMap = new LogMap();
    private final LogDivider logDivider = new LogDivider();
    private final LogSampler logSampler = new LogSampler();
    private String[] dividedResult;

    public LogAnalyzer(LogFileReader logFileReader) {
        this.logFileReader = logFileReader;
    }

    public void start() throws IOException {
        while(true) {
            lineOfLog = logFileReader.read();
            if(lineOfLog == null) {
                break;
            }
            logDivider.divide(lineOfLog);
            logSampler.samplingLog(logMap, logDivider.getDividedResult());
        }
        MaxCallApi maxCallApi = new MaxCallApi(logMap);
        Top3ServiceId top3ServiceId = new Top3ServiceId(logMap);
        PeakTime peakTime = new PeakTime(logMap);
        BrowserPercentage browserPercentage = new BrowserPercentage(logMap);
        maxCallApi.logicOfMaxCallApi();
        top3ServiceId.logicOfListServiceIds();
        peakTime.logicOfPeakTime();
        browserPercentage.logicOfBrowserPercentage();

//        logSampler.Print();
    }
}
