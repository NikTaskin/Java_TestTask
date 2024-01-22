package stats;

import java.text.DecimalFormat;
import java.util.List;

public class PrintStatistics {
    public void printStatistics(List<StatsEntry> stats, boolean summarize, boolean fullStats) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");

        for (StatsEntry entry : stats) {
            System.out.println("Statistics for " + entry.dataType + ":");
            System.out.println("Count: " + entry.count);
            if (fullStats) {
                if (entry.dataType == DataType.INTEGER || entry.dataType == DataType.FLOAT) {
                    System.out.println("Min: " + decimalFormat.format(entry.min));
                    System.out.println("Max: " + decimalFormat.format(entry.max));
                    System.out.println("Sum: " + decimalFormat.format(entry.sum));
                    System.out.println("Average: " + decimalFormat.format(entry.sum / entry.count));
                } else if (entry.dataType == DataType.STRING) {
                    System.out.println("Min Length: " + entry.minLength);
                    System.out.println("Max Length: " + entry.maxLength);
                }
            }
            if (!summarize) {
                System.out.println();
            }
        }
    }
}
