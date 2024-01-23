package processing;

import stats.PrintStatistics;
import stats.StatsEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessFiles {
    public void processFiles(String outputPath, String prefix, boolean appendMode,
                              boolean summarize, boolean fullStats, List<String> files) throws IOException {
        PrintStatistics statistics = new PrintStatistics();
        File integersFile = createFile(outputPath, prefix + "integers.txt");
        File floatsFile = createFile(outputPath, prefix + "floats.txt");
        File stringsFile = createFile(outputPath, prefix + "strings.txt");

        try (PrintWriter integersWriter = new PrintWriter(new FileWriter(integersFile, appendMode), true);
             PrintWriter floatsWriter = new PrintWriter(new FileWriter(floatsFile, appendMode), true);
             PrintWriter stringsWriter = new PrintWriter(new FileWriter(stringsFile, appendMode), true)) {

            List<StatsEntry> stats = new ArrayList<>();
            CreateReaders create = new CreateReaders();
            ClassifyAndWrite classify = new ClassifyAndWrite();


            List<BufferedReader> readers = create.createReaders(files);

            boolean processing = true;
            while (processing) {
                processing = false;

                for (BufferedReader reader : readers) {
                    String line = reader.readLine();
                    if (line != null) {
                        processing = true;
                        classify.classifyAndWrite(line, integersWriter, floatsWriter, stringsWriter, stats);
                    }
                }
            }

            printResults(integersFile, floatsFile, stringsFile);
            statistics.printStatistics(stats, summarize, fullStats);

        } catch (FileNotFoundException e) {
            System.out.println("Incorrect path to the directory after flag -o");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void printResults(File integersFile, File floatsFile, File stringsFile) {
        System.out.println("Processing completed. Results saved to: ");
        printFileStatus(integersFile, "Integers");
        printFileStatus(floatsFile, "Floats");
        printFileStatus(stringsFile, "Strings");
    }
    private void printFileStatus(File file, String type) {
        if (file.length() > 0) {
            System.out.println(type + ": " + file.getAbsolutePath());
        } else {
            file.delete();
        }
    }
    private static File createFile(String outputPath, String fileName) {
        File file = new File(outputPath, fileName);
        File parentDirectory = file.getParentFile();

        if (!parentDirectory.exists()) {
            if (!parentDirectory.mkdirs()) {
                System.out.println("Error: Could not create directory - " + parentDirectory.getAbsolutePath());
            }
        }
        return file;
    }
}
