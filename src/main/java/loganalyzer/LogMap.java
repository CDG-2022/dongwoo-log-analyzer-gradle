package loganalyzer;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LogMap {
    private Map<String, Integer> apiKey = new HashMap<>();
    private Map<String, Integer> stateCode = new HashMap<>();
    private Map<String, Integer> serviceId = new HashMap<>();
    private Map<String, Integer> time = new HashMap<>();
    private Map<String, Integer> browser = new HashMap<>();

}
