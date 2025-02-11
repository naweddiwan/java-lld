package tekionSplitWise.models;

import lombok.Getter;

@Getter
public class Expense {
    private String description;
    private double amount;
    private Split split;
    private String createBy;

    public Expense(String description, double amount, Split split, String createBy) {
        this.description = description;
        this.amount = amount;
        this.split = split;
        this.createBy = createBy;
    }
}
