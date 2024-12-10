package SplitWise.models;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private User createdByUser;
    private static int numExpense = 0;

    public Expense(double amount, String description, User createdByUser) {
        this.amount = amount;
        this.description = description;
        this.createdByUser = createdByUser;
        this.id = ++numExpense;
    }

    public int getId() {
        return id;
    }
}
