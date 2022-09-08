package loganalyzer;

import loganalyzer.LogAnalyzer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.start();
    }
}
