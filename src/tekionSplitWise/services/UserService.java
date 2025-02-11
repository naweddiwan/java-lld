package tekionSplitWise.services;

import tekionSplitWise.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService {
    private HashMap<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User createUser(String name) {
        User newUser = new User(name);
        return newUser;
    }

    public void addUser(User user) {
        // TODO: add validations
        users.put(user.getName(), user);
    }

    public boolean removeUser(User user){
        users.remove(user);
        return true;
    }

    public boolean isValidUser(String name) {
        return users.containsKey(name);
    }
    public User getUserByName(String name) {
        return users.get(name);
    }


}
