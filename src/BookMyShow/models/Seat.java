package BookMyShow.models;
import BookMyShow.enums.SeatCategory;

public class Seat {
    private int id;
    private int rowNo;
    private SeatCategory seatCategory;

    public Seat(int id, int rowNo, SeatCategory seatCategory) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatCategory = seatCategory;
    }
}
