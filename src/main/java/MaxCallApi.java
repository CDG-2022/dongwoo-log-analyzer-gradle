import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxCallApi {

    @Getter
    private List<String> listApiKeys;
    private LogMap logMap;

    public MaxCallApi(LogMap logMap) {
        this.logMap = logMap;
    }

    public void logicOfMaxCallApi() {
        listApiKeys = new ArrayList<>(logMap.getApiKey().keySet());
        listApiKeys.sort((o1, o2) -> logMap.getApiKey().get(o2).compareTo(logMap.getApiKey().get(o1)));
    }

}
