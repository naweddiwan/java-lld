package SplitWise.services;

import BookMyShow.exceptions.FriendNotFoundException;
import SplitWise.models.*;
import SplitWise.models.expense.Expense;
import SplitWise.models.expense.ExpenseSplit;
import SplitWise.models.expense.ExpenseSplitFactory;
import SplitWise.models.expense.Split;

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

    public Expense addExpenseAgainstAFriend(User createdByUser, User friend, Expense expense) {
        Split split = expense.getSplit();
        double amount = expense.getAmount();
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
        // update balance sheets of the user
        expenses.put(expense.getId(), expense);
        userService.updateBalanceSheet(createdByUser, expense);
        return expense;
    }

    private Expense addExpenseAgainstAGroup(User createdByUser, double amount, Group group, Split split, String desc) {
        return null;
    }

}
