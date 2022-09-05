package loganalyzer.file;

import loganalyzer.parsing.PeakTime;
import loganalyzer.ResultLog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileWriter {


    private static final String OUTPUT_FILE_NAME = "output.log";
    private final ResultLog resultLog;

    public LogFileWriter(ResultLog resultLog) {
        this.resultLog = resultLog;
    }

    public void writeLog() throws IOException {

        File file = new File(OUTPUT_FILE_NAME);
        if(!file.exists()) {
            file.createNewFile();
        }

        try(FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write("최다호출 APIKEY\n");
            fileWriter.write(String.valueOf(resultLog.getResultApiKeys()));
            fileWriter.flush();

            fileWriter.write("\n상태코드 별 횟수\n");
            fileWriter.write(String.valueOf(resultLog.getResultStateCodes()));
            fileWriter.flush();

            fileWriter.write("\n상위 3개의 API Service ID와 각각의 요청 수\n");
            fileWriter.write(String.valueOf(resultLog.getResultServiceIds()));
            fileWriter.flush();

            fileWriter.write("\n피크 시간대\n");
            fileWriter.write(String.valueOf(resultLog.getResultTimes()));
            fileWriter.flush();

            fileWriter.write("\n웹 브라우저 별 사용 비율\n");
            fileWriter.write(String.valueOf(resultLog.getResultBrowsers()));
            fileWriter.flush();
        }

    }

}
