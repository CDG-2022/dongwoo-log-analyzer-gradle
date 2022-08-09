import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    private static final String OUTPUT_FILE_NAME = "output.log";
    private BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE_NAME));


    public void read() throws IOException {
        while((br.readLine()) != null) {

        }
    }
}
