package stats;
public class StatsEntry {
    public DataType dataType;
    int count;
    double min;
    double max;
    double sum;
    int minLength;
    int maxLength;

    public StatsEntry(DataType dataType) {
        this.dataType = dataType;
    }
}
