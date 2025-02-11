package SplitWise.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private UserBalanceSheet userBalanceSheet;

    private static int numUsers = 0;
    Map<Integer, User> friends;

    public User(String name) {
        this.name = name;
        this.id = ++numUsers;
        userBalanceSheet = new UserBalanceSheet();
        friends = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void addFriend(User user) {
        friends.put(user.getId(), user);
        userBalanceSheet.addFriendInBalanceSheet(user);
    }

    public List<User> getFriends() {
        return friends.values().stream().toList();
    }


}
