package SplitWise.models.expense;

public interface ExpenseSplit {
    boolean validateRequest(double amount, Split split);
}
