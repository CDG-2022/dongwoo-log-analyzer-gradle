import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LogAnalyze logAnalyze = new LogAnalyze();

        try {
            FileReader fr = new FileReader("C://input.log");
            BufferedReader br = new BufferedReader(fr);
            while((br.readLine()) != null){
                logAnalyze.divide(br);
                logAnalyze.sampleStateCode();
            }
        } catch (FileNotFoundException e){
            System.out.println("파일을 찾지 못했습니다");
        }
        logAnalyze.Test();
    }
}
