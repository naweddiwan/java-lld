package tekionSplitWise.models;

import lombok.Getter;

@Getter
public class SplitEntry {
    private String name;
    private double amount;
    private double percentage;
    public SplitEntry(String name, double amount, double percentage) {
        this.name = name;
        this.amount = amount;
        this.percentage = percentage;
    }

}
