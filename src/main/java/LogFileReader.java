import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogFileReader {
    private static final String OUTPUT_FILE_NAME = "output.log";
    private BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE_NAME));

    public LogFileReader() throws FileNotFoundException {
    }

    public String read() throws IOException {
        return br.readLine();
    }
}
