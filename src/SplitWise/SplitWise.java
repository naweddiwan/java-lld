package SplitWise;

import SplitWise.enums.SplitType;
import SplitWise.models.split.Split;
import SplitWise.models.split.SplitEntry;
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

        splitWise.expenseService.addExpenseAgainstAFriend(nawed, 200.0, jawed, splitWise.getSplit(), "Biryani Dinner");

        UserBalanceSheet nawedBalanceSheet = splitWise.userService.getUserBalanceSheet(nawed);
        System.out.println("Hellow");

    }

    public Split getSplit() {
        SplitEntry splitEntry1 = new SplitEntry(100.0, 2);
        SplitEntry splitEntry2 = new SplitEntry(100.0, 1);
        List<SplitEntry> splitEntryList = new ArrayList<>();
        splitEntryList.add(splitEntry1);
        splitEntryList.add(splitEntry2);
        return new Split(SplitType.EQUAL, splitEntryList);
    }
}
