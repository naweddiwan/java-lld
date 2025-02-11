package tekionSplitWise;

import tekionSplitWise.models.*;
import tekionSplitWise.services.ExpenseService;
import tekionSplitWise.services.UserService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestSplitWise {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = userService.createUser("user1");
        User user2 = userService.createUser("user2");
        User user3 = userService.createUser("user3");
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);



        ExpenseService expenseService = new ExpenseService(userService);
        Split split = getSplit();

        Expense expense =new Expense("Dinner", 300.0, split ,"user1");
        expenseService.addExpense(expense);

        System.out.println(user1.getBalanceSheet().getAmount());
        System.out.println(user2.getBalanceSheet().getAmount());
        System.out.println(user3.getBalanceSheet().getAmount());

    }

    public static  Split getSplit() {
        List<SplitEntry> splitEntryList = new ArrayList<>();
        for(int i=1; i<=3; i++) {
            splitEntryList.add(new SplitEntry("user" + i, 0.0, 0.0));
        }

        return new Split(SplitType.EQUAL,splitEntryList);
    }
}