package SplitWise.models.expense;
import lombok.Getter;

@Getter
public class Balance {
    private double amountOwed;
    private double amountGetBack;

    public Balance() {
        this.amountOwed = 0.0;
        this.amountGetBack = 0.0;
    }


    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
