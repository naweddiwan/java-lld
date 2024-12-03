package BookMyShow.models;
import BookMyShow.enums.SeatCategory;
import BookMyShow.enums.SeatStatus;

public class Seat {
    private int id;
    private int rowNo;
    private SeatCategory seatCategory;
    private SeatStatus seatStatus;

    public Seat(int id, int rowNo, SeatCategory seatCategory) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatCategory = seatCategory;
        this.seatStatus = SeatStatus.EMPTY;
    }

    public int getId() {
        return id;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public boolean isSeatEmpty(){
        return this.seatStatus == SeatStatus.EMPTY;
    }

    public String seatDetails(){
        return " ID: " + this.id + " ROW NO: " + this.rowNo + " CATEGORY: " +this.seatCategory.toString();
    }


}
