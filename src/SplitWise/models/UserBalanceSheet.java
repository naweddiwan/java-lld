package SplitWise.models;

import SplitWise.models.expense.Balance;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    private Map<User, Balance> friendBalanceSheet;
    private double totalOwed;
    private double totalGetBack;

    public UserBalanceSheet() {
        this.friendBalanceSheet = new HashMap<>();
        this.totalOwed = 0.0;
        this.totalGetBack = 0.0;
    }

    public Map<User, Balance> getFriendBalanceSheet() {
        return friendBalanceSheet;
    }

    public void addFriendInBalanceSheet(User friend) {
        friendBalanceSheet.put(friend, new Balance());
    }

    public double getTotalOwed() {
        return totalOwed;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void addFriendBalance(User friend, Balance b) {
        friendBalanceSheet.put(friend, b);
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    public void setTotalOwed(double totalOwed) {
        this.totalOwed = totalOwed;
    }
}
