import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LogMap {
    private Map<String, Integer> apiKey = new HashMap<>();
    private Map<String, Integer> stateCode = new HashMap<>();
    private Map<String, Integer> serviceId = new HashMap<>();
    private Map<String, Integer> Time = new HashMap<>();
    private Map<String, Integer> browser = new HashMap<>();\
}
