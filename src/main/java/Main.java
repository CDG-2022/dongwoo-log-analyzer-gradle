import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LogAnalyze logAnalyze = new LogAnalyze();
        PrintMaxCall printMaxCall = new PrintMaxCall();

        try (BufferedReader br = new BufferedReader(new FileReader("C://input.log"))){
            while((br.readLine()) != null){
                logAnalyze.divide(br);
                logAnalyze.sampleStateCode();
                logAnalyze.sampleApiKey();
                logAnalyze.sampleServiceId();
                logAnalyze.sampleBrowser();
                logAnalyze.sampleTime();
            }
        } catch (FileNotFoundException e){
            System.out.println("파일을 찾지 못했습니다");
        }
        logAnalyze.PrintResult();
//        logAnalyze.Test();
    }
}
