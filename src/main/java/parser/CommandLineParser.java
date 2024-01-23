package parser;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {
    private String outputPath = ".";
    private String prefix = "";
    private boolean appendMode = false;
    private boolean summarize = false;
    private boolean fullStats = false;
    private List<String> files = new ArrayList<>();

    public CommandLineParser(String[] args) {
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o" -> {
                    if (i + 1 < args.length) {
                        outputPath = args[i + 1];
                        i++;
                    }
                }
                case "-p" -> {
                    if (i + 1 < args.length) {
                        prefix = args[i + 1];
                        i++;
                    }
                }
                case "-a" -> appendMode = true;
                case "-s" -> summarize = true;
                case "-f" -> fullStats = true;
                default -> files.add(args[i]);
            }
        }
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public boolean isSummarize() {
        return summarize;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public List<String> getFiles() {
        return files;
    }
}
