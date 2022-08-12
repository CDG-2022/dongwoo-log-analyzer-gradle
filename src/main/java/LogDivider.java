import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class LogDivider {
    @Getter
    private String[] dividedResult;

    public void divide(String lineOfLog) {
        System.out.println(lineOfLog);
        dividedResult = substringsBetween(lineOfLog, "[", "]");
    }
}
