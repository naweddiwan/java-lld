package tekionSplitWise.models;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private BalanceSheet balanceSheet;

    public User(String name) {
        this.name = name;
        this.balanceSheet = new BalanceSheet();
    }
}
