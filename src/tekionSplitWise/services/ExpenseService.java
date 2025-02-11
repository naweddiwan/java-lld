package tekionSplitWise.services;

import tekionSplitWise.models.Expense;
import tekionSplitWise.models.Split;
import tekionSplitWise.models.SplitEntry;
import tekionSplitWise.models.SplitType;
import tekionSplitWise.models.splitHandlers.SplitHandler;
import tekionSplitWise.models.splitHandlers.SplitHandlerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenseList;
    private UserService userService;
    private SplitHandlerFactory splitHandlerFactory;
    private SplitHandler splitHandler;

    public ExpenseService(UserService userService) {
        this.expenseList = new ArrayList<>();
        this.userService = userService;
        this.splitHandlerFactory = new SplitHandlerFactory();
    }

    public void addExpense(Expense expense) {
        // 1. Add expense to the
        // 2. Check all the users are valid or not
        Split split = expense.getSplit();
        List<SplitEntry> splitEntries = split.getSplitEntries();
        for(SplitEntry se: splitEntries) {
            if(!userService.isValidUser(se.getName())) {
                throw new RuntimeException("Invalid User added in expense");
            }
        }

        // 3. Add expense
        // 3. 1 Split expense
        splitHandler = splitHandlerFactory.getSplitHandler(split.getSplitType());

        splitHandler.split(expense, userService);
    }


}
