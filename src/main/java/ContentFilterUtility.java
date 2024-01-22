import parser.CommandLineParser;
import processing.ProcessFiles;

import java.io.IOException;

public class ContentFilterUtility {
    public static void main(String[] args) {
        ContentFilterUtility contentFilter = new ContentFilterUtility();
        contentFilter.run(args);
    }

    private void run(String[] args) {
        if (args.length == 0) {
            printUsageAndExit();
        }

        CommandLineParser parser = new CommandLineParser(args);
        ProcessFiles process = new ProcessFiles();

        String outputPath = parser.getOutputPath();
        String prefix = parser.getPrefix();
        boolean appendMode = parser.isAppendMode();
        boolean summarize = parser.isSummarize();
        boolean fullStats = parser.isFullStats();

        try {
            process.processFiles(outputPath, prefix, appendMode, summarize, fullStats, parser.getFiles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printUsageAndExit() {
        System.out.println("Usage: java ContentFilterUtility [-o <outputPath>] [-p <prefix>] [-a] [-s|-f] <file1> <file2> ... ");
        System.exit(1);
    }
}
