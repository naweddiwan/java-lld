package SplitWise.services;

import SplitWise.models.*;
import SplitWise.models.split.Split;
import SplitWise.models.split.SplitEntry;

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

    public boolean updateBalanceSheet(User createdByUser, Split split){
        List<SplitEntry> splitEntries = split.getSplitEntryList();
        UserBalanceSheet userBalanceSheet =  createdByUser.getUserBalanceSheet();
        double getBackFromSplit = 0.0;
        for(SplitEntry se: splitEntries) {
            User friend = users.get(se.getUserID());
            double amount = se.getAmount();
            getBackFromSplit += amount;

            addSplit(createdByUser, friend, se);

        }
        userBalanceSheet.setTotalGetBack(userBalanceSheet.getTotalGetBack() + getBackFromSplit);
        return true;
    }

    public void addSplit(User userCreated, User friend, SplitEntry se){
        UserBalanceSheet friendBalanceSheet = friend.getUserBalanceSheet();
        UserBalanceSheet userBalanceSheet =  userCreated.getUserBalanceSheet();

        Balance userFriendBalance = friendBalanceSheet.getFriendBalanceSheet().get(userCreated);
        userFriendBalance.setAmountOwed(userFriendBalance.getAmountOwed() + se.getAmount());

        Balance friendBalance = userBalanceSheet.getFriendBalanceSheet().get(friend);
        friendBalance.setAmountOwed(friendBalance.getAmountOwed() + se.getAmount());
    }

    public UserBalanceSheet getUserBalanceSheet(User user) {
        return user.getUserBalanceSheet();
    }
}
