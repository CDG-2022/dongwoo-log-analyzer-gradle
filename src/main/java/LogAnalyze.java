import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class LogAnalyze {

    private HashMap<String, Integer> apiKey = new HashMap<>();
    private HashMap<String, Integer> stateCode = new HashMap<>();
    private HashMap<String, Integer> serviceId = new HashMap<>();
    private HashMap<String, Integer> Time = new HashMap<>();
    private HashMap<String, Integer> browser = new HashMap<>();

    private String [] string;

    public void divide(BufferedReader log) throws IOException {
        string = substringsBetween(log.readLine(), "[", "]");
    }

    public void sampleApiKey() {
        String sampledApiKey = StringUtils.substringBetween(string[1], "apikey=", "&");
        apiKey.put(sampledApiKey, apiKey.getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode() {
        stateCode.put(string[0], stateCode.getOrDefault(string[0], 0) + 1);
    }

    public void sampleServiceId() {

    }

    public void sampleTime() {

    }

    public void browser() {

    }

    public void Test() {
        stateCode.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        apiKey.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

}
