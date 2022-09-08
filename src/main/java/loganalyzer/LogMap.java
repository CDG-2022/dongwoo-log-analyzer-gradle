package loganalyzer;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LogMap {
    private final Map<String, Integer> apiKey = new HashMap<>();
    private final Map<String, Integer> stateCode = new HashMap<>();
    private final Map<String, Integer> serviceId = new HashMap<>();
    private final Map<String, Integer> time = new HashMap<>();
    private final Map<String, Integer> browser = new HashMap<>();

}
