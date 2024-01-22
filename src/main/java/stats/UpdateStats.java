package stats;

import java.util.List;

public class UpdateStats {
    public void updateStats(List<StatsEntry> stats, DataType dataType, String data) {
        for (StatsEntry entry : stats) {
            if (entry.dataType == dataType) {
                entry.count++;
                if (dataType == DataType.INTEGER || dataType == DataType.FLOAT) {
                    double value = Double.parseDouble(data);
                    entry.sum += value;
                    if (value < entry.min) {
                        entry.min = value;
                    }
                    if (value > entry.max) {
                        entry.max = value;
                    }
                } else if (dataType == DataType.STRING) {
                    int length = data.length();
                    if (length < entry.minLength) {
                        entry.minLength = length;
                    }
                    if (length > entry.maxLength) {
                        entry.maxLength = length;
                    }
                }
                return;
            }
        }

        StatsEntry newEntry = new StatsEntry(dataType);
        newEntry.count++;
        if (dataType == DataType.INTEGER || dataType == DataType.FLOAT) {
            double value = Double.parseDouble(data);
            newEntry.sum += value;
            newEntry.min = value;
            newEntry.max = value;
        } else if (dataType == DataType.STRING) {
            int length = data.length();
            newEntry.minLength = length;
            newEntry.maxLength = length;
        }
        stats.add(newEntry);
    }
}
