package loganalyzer.parsing;

import loganalyzer.LogMap;
import loganalyzer.ResultLog;

import java.util.ArrayList;
import java.util.List;

public class Top3ServiceId {

    private static final int API_SERVICE_ID_TOP = 3;
    private List<String> listServiceIds;
    private LogMap logMap;
    private ResultLog resultLog;

    public Top3ServiceId(LogMap logMap, ResultLog resultLog) {
        this.logMap = logMap;
        this.resultLog = resultLog;
    }

    public void logicOfListServiceIds() {
        listServiceIds = new ArrayList<>(logMap.getServiceId().keySet());
        listServiceIds.sort((o1, o2) -> logMap.getServiceId().get(o2).compareTo(logMap.getServiceId().get(o1)));
        int listServiceIdsSize = listServiceIds.size();
        for(int i = API_SERVICE_ID_TOP; i < listServiceIdsSize; i++){
            listServiceIds.remove(API_SERVICE_ID_TOP);
        }
        resultLog.setResultServiceIds(listServiceIds);
    }
}
