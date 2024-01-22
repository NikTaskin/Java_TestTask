package processing;

import processing.check.IsFileEmpty;
import processing.check.IsValidFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CreateReaders {
    public List<BufferedReader> createReaders(List<String> files) {
        List<BufferedReader> readers = new ArrayList<>();
        IsValidFile valid = new IsValidFile();
        IsFileEmpty empty = new IsFileEmpty();
        for (String file : files) {
            if (!file.startsWith("-")) {
                File inputFile = new File(file);
                if (empty.isFileEmpty(inputFile)) {
                    System.out.println("Warning: File is empty - " + inputFile.getAbsolutePath());
                }
                if (valid.isValidFile(inputFile)) {
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(inputFile));
                        readers.add(reader);
                    } catch (FileNotFoundException e) {
                        System.out.println("Warning: File not found - " + inputFile.getAbsolutePath());
                    }
                } else {
                    System.out.println("Warning: Invalid file - " + inputFile.getAbsolutePath());
                }
            }
        }
        return readers;
    }
}
