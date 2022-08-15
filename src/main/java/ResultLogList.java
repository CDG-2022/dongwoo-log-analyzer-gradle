import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultLogList {
    private List<String> resultApiKey = new ArrayList<>();
    private List<String> resultStateCode = new ArrayList<>();
    private List<String> resultServiceId = new ArrayList<>();
    private List<String> resultTime = new ArrayList<>();
    private List<String> resultBrowser = new ArrayList<>();
}
