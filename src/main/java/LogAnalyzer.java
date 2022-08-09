import java.io.IOException;

public class LogAnalyzer {

    private LogFileReader logFileReader;

    public LogAnalyzer(LogFileReader logFileReader) {
        this.logFileReader = logFileReader;
    }

    public void start() throws IOException {
        while(logFileReader.read() != null) {
            

        }
    }
}
