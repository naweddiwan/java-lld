package SplitWise.models.expense;

import SplitWise.models.User;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private User createdByUser;
    private static int numExpense = 0;
    private Split split;

    public Expense(double amount, String description, User createdByUser, Split split) {
        this.amount = amount;
        this.description = description;
        this.createdByUser = createdByUser;
        this.split = split;
        this.id = ++numExpense;

    }

    public int getId() {
        return id;
    }

    public Split getSplit() {
        return split;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
