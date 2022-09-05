package loganalyzer.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogFileReader {
    private static final String OUTPUT_FILE_NAME = "input.log";
    private final BufferedReader br;

    public LogFileReader() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
    }

    public String read() throws IOException {
        return br.readLine();
    }

    public void LogFileCloser() throws IOException {
        br.close();
    }
}
