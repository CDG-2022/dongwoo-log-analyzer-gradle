package loganalyzer;

import loganalyzer.LogAnalyzer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.start();
    }
}
