import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class LogAnalyze {

    private Map<String, Integer> apiKey = new HashMap<>();
    private Map<String, Integer> stateCode = new HashMap<>();
    private Map<String, Integer> serviceId = new HashMap<>();
    private Map<String, Integer> Time = new HashMap<>();
    private Map<String, Integer> browser = new HashMap<>();

    private List<String> resultApiKey = new ArrayList<>();
    private List<String> resultStateCode = new ArrayList<>();
    private List<String> resultServiceId = new ArrayList<>();
    private List<String> resultTime = new ArrayList<>();
    private List<String> resultBrowser = new ArrayList<>();

    private String [] string;

    public void divide(BufferedReader log) throws IOException {
//        List<DividedLog> list = new ArrayList<>();
//        Integer size = list.stream().filter(item -> item.stateCode.equals("200")).size();
        string = substringsBetween(log.readLine(), "[", "]");
    }
        
    public void sampleApiKey() {
        String sampledApiKey = substringBetween(string[1], "apikey=", "&");
        apiKey.put(sampledApiKey, apiKey.getOrDefault(sampledApiKey, 0) + 1);
    }

    public void sampleStateCode() {
        stateCode.put(string[0], stateCode.getOrDefault(string[0], 0) + 1);
    }

    public void sampleServiceId() {
        String sampledServiceId = substringBetween(string[1], "search/", "?");
        serviceId.put(sampledServiceId, serviceId.getOrDefault(sampledServiceId, 0) + 1);
    }

    public void sampleTime() {
        Time.put(string[3].substring(0, string[3].length()-3),
                Time.getOrDefault(string[3].substring(0, string[3].length()-3), 0) + 1);
    }

    public void sampleBrowser() {
        browser.put(string[2], browser.getOrDefault(string[2], 0) + 1);
    }

    public void Test() {
        stateCode.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        apiKey.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        serviceId.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        browser.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println();
        Time.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    public void PrintResult() throws IOException {
        File file = new File("output.log");
        if(!file.exists()) {
            file.createNewFile();
        }
        try(FileWriter fileWriter = new FileWriter(file)){
            List<String> listApiKey = new ArrayList<>(apiKey.keySet());
            listApiKey.sort((o1, o2) -> apiKey.get(o2).compareTo(apiKey.get(o1)));
            fileWriter.write("최다호출 APIKEY\n");
            fileWriter.write(listApiKey.get(0) + " " +  apiKey.get(listApiKey.get(0)) + "회\n\n");
            fileWriter.flush();

            fileWriter.write("상태코드 별 횟수\n");
            fileWriter.write(stateCode + "\n\n");
            fileWriter.flush();

            fileWriter.write("상위 3개의 API Service ID와 각각의 요청 수\n");
            List<String> listServiceId = new ArrayList<>(serviceId.keySet());
            listServiceId.sort((o1, o2) -> serviceId.get(o2).compareTo(serviceId.get(o1)));
            for(int i = 0; i < 3; i++) {
                fileWriter.write(listServiceId.get(i) + " " +  serviceId.get(listServiceId.get(i)) + "회\n\n");
                fileWriter.flush();
            }

            fileWriter.write("피크 시간대\n");
            List<String> listTime = new ArrayList<>(Time.keySet());
            listTime.sort((o1, o2) -> Time.get(o2).compareTo(Time.get(o1)));
            fileWriter.write(listTime.get(0) + " " +  Time.get(listTime.get(0)) + "\n\n");

            fileWriter.write("웹 브라우저 별 사용 비율\n");
            List<String> listBrowser = new ArrayList<>(browser.keySet());
            listBrowser.sort((o1, o2) -> browser.get(o2).compareTo(browser.get(o1)));
            int total = 0;
            for(int i = 0; i < listBrowser.size(); i++) {
                total =+ browser.get(listBrowser.get(i));
            }

            System.out.println(total);

            for(int i = 0; i < listBrowser.size(); i++) {
                fileWriter.write(listBrowser.get(i) + " " + ((double)browser.get(listBrowser.get(i))/total*100 + "%\n\n"));
                fileWriter.flush();
            }


            fileWriter.flush();
        }
    }
}
