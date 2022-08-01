
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PrintMaxCall implements Print{
    private LogAnalyze logAnalyze;

    public void printMaxCall(HashMap<String, Integer> map) throws IOException {

        ArrayList<String> listApiKey = new ArrayList<>(map.keySet());
        listApiKey.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        File file = new File("C://output.log");
        FileWriter fileWriter = new FileWriter(file);
        if(!file.exists()) {
            file.createNewFile();
        }
        fileWriter.write("최다호출 APIKEY\n");
        fileWriter.write(listApiKey.get(0) + " " +  map.get(listApiKey.get(0)) + "회");
        fileWriter.flush();
        fileWriter.close();
    }

}
