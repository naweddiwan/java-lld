package SplitWise.services;

import SplitWise.enums.SplitType;
import SplitWise.models.*;
import SplitWise.models.expense.Balance;
import SplitWise.models.expense.Expense;
import SplitWise.models.expense.Split;
import SplitWise.models.expense.SplitEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    Map<Integer, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public User addUser(String name) {
        User newUser = new User(name);
        users.put(newUser.getId(), newUser);
        return newUser;
    }

    public void addFriend(User user1, User user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public List<User> getUserFriends(User user){
        return user.getFriends();
    }

    public boolean updateBalanceSheet(User createdByUser, Expense expense){
        Split split = expense.getSplit();
        List<SplitEntry> splitEntries = split.getSplitEntryList();
        UserBalanceSheet userBalanceSheet =  createdByUser.getUserBalanceSheet();
        int splitsLength = splitEntries.size();

        if(split.getSplitType() == SplitType.EQUAL) {
            // Equal Split
            double splitAmount = expense.getAmount()/ (splitsLength + 1);
            for(SplitEntry se: splitEntries) {
                User friend = users.get(se.getUserID());
                addEqualSplit(createdByUser, friend, splitAmount);
            }
            userBalanceSheet.setTotalGetBack(userBalanceSheet.getTotalGetBack() + (expense.getAmount() - splitAmount));
            return true;
        }
        return false;
    }

    public void addEqualSplit(User userCreated, User friend, double splitAmount){
        UserBalanceSheet friendBalanceSheet = friend.getUserBalanceSheet();
        UserBalanceSheet userBalanceSheet =  userCreated.getUserBalanceSheet();

        Balance userFriendBalance = friendBalanceSheet.getFriendBalanceSheet().get(userCreated);
        userFriendBalance.setAmountOwed(userFriendBalance.getAmountOwed() + splitAmount);

        friendBalanceSheet.setTotalOwed(friendBalanceSheet.getTotalOwed() + splitAmount);

        Balance friendBalance = userBalanceSheet.getFriendBalanceSheet().get(friend);
        friendBalance.setAmountOwed(friendBalance.getAmountOwed() + splitAmount);
    }

    public UserBalanceSheet getUserBalanceSheet(User user) {
        return user.getUserBalanceSheet();
    }
}
