package SplitWise;

import SplitWise.enums.SplitType;
import SplitWise.models.expense.Expense;
import SplitWise.models.expense.Split;
import SplitWise.models.expense.SplitEntry;
import SplitWise.models.User;
import SplitWise.models.UserBalanceSheet;
import SplitWise.services.ExpenseService;
import SplitWise.services.GroupService;
import SplitWise.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    UserService userService;
    GroupService groupService;
    ExpenseService expenseService;

    SplitWise() {
        userService = new UserService();
        groupService = new GroupService();
        expenseService = new ExpenseService(groupService, userService);
    }

    public static void main(String[] args) {
        SplitWise splitWise = new SplitWise();
        User nawed = splitWise.userService.addUser("Nawed");
        User jawed = splitWise.userService.addUser("Jawed");
        splitWise.userService.addFriend(nawed, jawed);
        Split split = splitWise.getSplit();
        Expense expense = new Expense(200.0, "Biryani Dinner", nawed, split);

        splitWise.expenseService.addExpenseAgainstAFriend(nawed, jawed, expense);

        UserBalanceSheet nawedBalanceSheet = splitWise.userService.getUserBalanceSheet(nawed);
        System.out.println(nawedBalanceSheet.getTotalGetBack() + "   " + nawedBalanceSheet.getTotalOwed());

        System.out.println();

        System.out.println(nawedBalanceSheet.getFriendBalanceSheet().get(jawed).getAmountOwed() + "  expected 100") ;
        System.out.println(nawedBalanceSheet.getFriendBalanceSheet().get(jawed).getAmountGetBack() + " expected 0");

        UserBalanceSheet jawedBalanceSheet = splitWise.userService.getUserBalanceSheet(jawed);
        System.out.println(jawedBalanceSheet.getFriendBalanceSheet().get(nawed).getAmountOwed() + "  expected 100");
        System.out.println(jawedBalanceSheet.getFriendBalanceSheet().get(nawed).getAmountGetBack() + " expected 0");

        System.out.println(nawedBalanceSheet.getTotalOwed() + "   expected 0");
        System.out.println(nawedBalanceSheet.getTotalGetBack() + "  expected  100" );

        System.out.println(jawedBalanceSheet.getTotalOwed() + "   expected 100");
        System.out.println(jawedBalanceSheet.getTotalGetBack() + "  expected  0" );

    }

    public Split getSplit() {
        SplitEntry splitEntry1 = new SplitEntry(2);
        List<SplitEntry> splitEntryList = new ArrayList<>();
        splitEntryList.add(splitEntry1);
        return new Split(SplitType.EQUAL, splitEntryList);
    }
}
