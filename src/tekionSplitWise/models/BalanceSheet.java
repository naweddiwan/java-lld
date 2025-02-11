package tekionSplitWise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class BalanceSheet {
    private double amount;
    private HashMap<String, Double> friendBalance;

    public BalanceSheet() {
        this.amount = 0.0;
        this.friendBalance = new HashMap<>();
    }
}
