package processing;

import stats.DataType;
import stats.StatsEntry;
import stats.UpdateStats;

import java.io.PrintWriter;
import java.util.List;

public class ClassifyAndWrite {
    public void classifyAndWrite(String data, PrintWriter integersWriter, PrintWriter floatsWriter,
                                  PrintWriter stringsWriter, List<StatsEntry> stats) {
        UpdateStats statistic = new UpdateStats();
        try {
            if (data.matches("^-?\\d+$")) {
                writeToFile(data, integersWriter);
                statistic.updateStats(stats, DataType.INTEGER, data);
            } else if (data.matches("^-?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?$")) {
                writeToFile(data, floatsWriter);
                statistic.updateStats(stats, DataType.FLOAT, data);
            } else {
                writeToFile(data, stringsWriter);
                statistic.updateStats(stats, DataType.STRING, data);
            }
        } catch (NumberFormatException e) {
            writeToFile(data, stringsWriter);
            statistic.updateStats(stats, DataType.STRING, data);
        }
    }

    private void writeToFile(String data, PrintWriter writer) {
        writer.println(data);
    }
}
