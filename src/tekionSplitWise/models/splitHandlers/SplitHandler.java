package tekionSplitWise.models.splitHandlers;

import tekionSplitWise.models.Expense;
import tekionSplitWise.services.UserService;

public interface SplitHandler {
    void split(Expense expense, UserService userService);
}
