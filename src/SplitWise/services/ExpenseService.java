package SplitWise.services;

import BookMyShow.exceptions.FriendNotFoundException;
import SplitWise.models.*;
import SplitWise.models.split.ExpenseSplit;
import SplitWise.models.split.ExpenseSplitFactory;
import SplitWise.models.split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {
    private Map<Integer, Expense> expenses;
    private GroupService groupService;
    private UserService userService;
    private ExpenseSplitFactory expenseSplitFactory;

    public ExpenseService(GroupService groupService, UserService userService) {
        this.expenses = new HashMap<>();
        this.groupService = groupService;
        this.userService = userService;
        this.expenseSplitFactory = new ExpenseSplitFactory();
    }

    public Expense addExpenseAgainstAFriend(User createdByUser, double amount, User friend, Split split, String desc) {
        // 1. Check if friends
        List<User> userFriends = userService.getUserFriends(createdByUser);
        if(!userFriends.contains(friend)){
            throw new FriendNotFoundException();
        }
        // validate request
        ExpenseSplit expenseSplit = expenseSplitFactory.getExpenseSplit(split.getSplitType());
        boolean isRequestValid = expenseSplit.validateRequest(amount, split);
        if(!isRequestValid) {
            return null;
        }

        // add expense
        // update balance sheets of the users
        Expense newExpense = new Expense(amount, desc, createdByUser);
        expenses.put(newExpense.getId(), newExpense);
        userService.updateBalanceSheet(createdByUser, split);
        return newExpense;
    }

    private Expense addExpenseAgainstAGroup(User createdByUser, double amount, Group group, Split split, String desc) {
        return null;
    }

}
