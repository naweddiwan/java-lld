package SplitWise.models;

import SplitWise.services.ExpenseService;

import java.util.Map;

public class Group {
    private int id;
    private String name;
    private Map<Integer, User> users;
    private ExpenseService expenseService;

    public Group(int id, String name, Map<Integer, User> users, ExpenseService expenseService) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.expenseService = expenseService;
    }
}
