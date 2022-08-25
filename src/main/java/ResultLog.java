import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
public class ResultLog {
    private List<String> resultApiKeys = new ArrayList<>();
    private Map<String, Integer> resultStateCodes = new HashMap<>();
    private List<String> resultServiceIds = new ArrayList<>();
    private List<String> resultTimes = new ArrayList<>();
    private Map<String, Double> resultBrowsers = new HashMap<>();
}
