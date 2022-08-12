import lombok.Getter;

import java.io.IOException;

public class LogAnalyzer {

    @Getter
    private String lineOfLog;
    private final LogFileReader logFileReader;
    private final LogMap logMap = new LogMap();
    private final LogDivider logDivider = new LogDivider();
    private LogSampler logSampler;


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
            logSampler.samplingLog(logDivider.getDividedResult());
            logSampler()
        }
    }
}
