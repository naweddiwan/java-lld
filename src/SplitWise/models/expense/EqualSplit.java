package SplitWise.models.expense;

public class EqualSplit implements ExpenseSplit {

    @Override
    public boolean validateRequest(double amount, Split split) {
        return true;
    }
}
