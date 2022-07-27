
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;


public class LogAnalyze {

    private HashMap<String, Integer> apiKey = new HashMap<>();
    private HashMap<String, Integer> stateCode = new HashMap<>();
    private HashMap<String, Integer> serviceId = new HashMap<>();
    private HashMap<String, Integer> Time = new HashMap<>();
    private HashMap<String, Integer> browser = new HashMap<>();

    private String [] string;

    public void divide(BufferedReader log) throws IOException {

        List<String> list = new ArrayList<>();
        Integer size = list.stream().filter(item -> item.stateCode.equals("200")).size();
        string = substringsBetween(log.readLine(), "[", "]");
//        string  = substringBetween(log.readLine(), "[", "]");
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
    }

}
