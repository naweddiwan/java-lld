package tekionSplitWise.models.splitHandlers;

import tekionSplitWise.models.Expense;
import tekionSplitWise.models.Split;
import tekionSplitWise.models.SplitEntry;
import tekionSplitWise.models.User;
import tekionSplitWise.services.UserService;

import java.util.Objects;

public class EqualSplitHandler implements SplitHandler {
    @Override
    public void split(Expense expense, UserService userService) {
        // 1. Validate Equal Request
        Split split = expense.getSplit();
        double amount = expense.getAmount();
        int totalUsers = split.getSplitEntries().size();

        double individualAmount = amount / totalUsers;

        User createdByUser = userService.getUserByName(expense.getCreateBy());
        double owedToCreatrer = amount - individualAmount;

        createdByUser.getBalanceSheet().setAmount(createdByUser.getBalanceSheet().getAmount() + owedToCreatrer);

        for(SplitEntry se: split.getSplitEntries()) {
            // 1 . Add the balance to created with +ve
            if(Objects.equals(se.getName(), expense.getCreateBy())){
                continue;
            }

            User friend = userService.getUserByName(se.getName());
            friend.getBalanceSheet().setAmount(friend.getBalanceSheet().getAmount() - individualAmount);

            if(friend.getBalanceSheet().getFriendBalance().containsKey(expense.getCreateBy())) {
                double currentBalanceAgainstFriend = friend.getBalanceSheet().getFriendBalance().get(expense.getCreateBy());
                friend.getBalanceSheet().getFriendBalance().put(expense.getCreateBy(),  currentBalanceAgainstFriend - individualAmount) ;
            }else{
                friend.getBalanceSheet().getFriendBalance().put(expense.getCreateBy(),  -individualAmount) ;
            }

            if(createdByUser.getBalanceSheet().getFriendBalance().containsKey(friend.getName())) {
                double currentBalance = createdByUser.getBalanceSheet().getFriendBalance().get(expense.getCreateBy()) ;
                createdByUser.getBalanceSheet().getFriendBalance().put(friend.getName(), currentBalance + individualAmount);
            }else{
                createdByUser.getBalanceSheet().getFriendBalance().put(friend.getName(), individualAmount);
            }
        }
    }
}

/**
 * {
 *     u1
 *     aount
 * }
 * {
 *     u2
 *
 * }
 * {
 *
 * }
 * */