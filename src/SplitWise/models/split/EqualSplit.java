package SplitWise.models.split;

import java.util.HashSet;

public class EqualSplit implements ExpenseSplit {

    @Override
    public boolean validateRequest(double amount, Split split) {
        double totalFromSplit = 0.0;
        HashSet<Double> set = new HashSet<>();
        for(SplitEntry se: split.getSplitEntryList()) {
            totalFromSplit += se.getAmount();
            set.add(se.getAmount());
        }
        return totalFromSplit == amount && set.size() == 1;
    }
}
