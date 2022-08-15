import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Top3ServiceId {
    private static final int API_SERVICE_ID_TOP = 3;
    @Getter
    private List<String> listServiceIds;
    private LogMap logMap;

    public Top3ServiceId(LogMap logMap) {
        this.logMap = logMap;
    }

    public void logicOfListServiceIds() {
        listServiceIds = new ArrayList<>(logMap.getServiceId().keySet());
        listServiceIds.sort((o1, o2) -> logMap.getServiceId().get(o2).compareTo(logMap.getServiceId().get(o1)));
        int listServiceIdsSize = listServiceIds.size();
        for(int i = API_SERVICE_ID_TOP; i < listServiceIdsSize; i++){
            listServiceIds.remove(API_SERVICE_ID_TOP);
        }
    }
}
