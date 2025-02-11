package SplitWise.models.expense;

import SplitWise.enums.SplitType;

public class ExpenseSplitFactory {
    public ExpenseSplit getExpenseSplit(SplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualSplit();
            case EXPLICIT -> null;
            default -> null;
        };

    }
}
