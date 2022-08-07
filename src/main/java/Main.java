import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final String OUTPUT_FILE_NAME = "input.log";

    public static void main(String[] args) throws IOException {

        LogAnalyzer logAnalyzer = new LogAnalyzer();
        PrintMaxCall printMaxCall = new PrintMaxCall();

        try (BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE_NAME))){
            while((br.readLine()) != null){
                logAnalyzer.divide(br);
                logAnalyzer.sampleStateCode();
                logAnalyzer.sampleApiKey();
                logAnalyzer.sampleServiceId();
                logAnalyzer.sampleBrowser();
                logAnalyzer.sampleTime();
            }
        } catch (FileNotFoundException e){
            System.out.println("파일을 찾지 못했습니다");
        }
        logAnalyzer.printResult();
//        logAnalyze.Test();
    }
}
