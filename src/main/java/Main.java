import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        LogFileReader logFileReader = new LogFileReader();
        LogAnalyzer logAnalyzer = new LogAnalyzer(logFileReader);
        logAnalyzer.start();
    }
}
