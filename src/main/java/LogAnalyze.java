
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class LogAnalyze {

    private HashMap<String, Integer> apiKey = new HashMap<>();
    private HashMap<String, Integer> stateCode = new HashMap<>();
    private HashMap<String, Integer> serviceId = new HashMap<>();
    private HashMap<String, Integer> Time = new HashMap<>();
    private HashMap<String, Integer> browser = new HashMap<>();

    private HashMap<String, Integer> resultApiKey = new HashMap<>();
    private HashMap<String, Integer> resultStateCode = new HashMap<>();
    private HashMap<String, Integer> resultServiceId = new HashMap<>();
    private HashMap<String, Integer> resultTime = new HashMap<>();
    private HashMap<String, Integer> resultBrowser = new HashMap<>();

    private String [] string;

    public void divide(BufferedReader log) throws IOException {
//        List<DividedLog> list = new ArrayList<>();
//        Integer size = list.stream().filter(item -> item.stateCode.equals("200")).size();
        string = substringsBetween(log.readLine(), "[", "]");
    }
        
    public void sampleApiKey() {
        String sampledApiKey = substringBetween(string[1], "apikey=", "&");
        apiKey.put(sampledApiKey, apiKey.getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode() {
        stateCode.put(string[0], stateCode.getOrDefault(string[0], 0) + 1);
    }

    public void sampleServiceId() {
        String sampledServiceId = substringBetween(string[1], "search/", "?");
        serviceId.put(sampledServiceId, serviceId.getOrDefault(sampledServiceId, 0) + 1);
    }

    public void sampleTime() {
        Time.put(string[3].substring(0, string[3].length()-3),
                Time.getOrDefault(string[3].substring(0, string[3].length()-3), 0) + 1);
    }

    public void sampleBrowser() {
        stateCode.put(string[2], stateCode.getOrDefault(string[0], 0) + 1);
    }

    public void Test() {
        stateCode.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        apiKey.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        serviceId.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        browser.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        Time.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    public void PrintResult() throws IOException {
        PrintMaxCall printMaxCall = new PrintMaxCall();
        printMaxCall.printMaxCall(apiKey);
    }
}
