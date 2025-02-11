package SplitWise.models.expense;

public class SplitEntry {
    private int userID;
    private double amount;
    private int percentage;

    public SplitEntry(double amount, int userID) {
        this.amount = amount;
        this.userID = userID;
    }

    public SplitEntry(int percentage, int userID) {
        this.percentage = percentage;
        this.userID = userID;
    }

    public SplitEntry(int userID){
        this.userID = userID;
    }


    public int getUserID() {
        return userID;
    }

    public double getAmount() {
        return amount;
    }

    public int getPercentage() {
        return percentage;
    }
}
