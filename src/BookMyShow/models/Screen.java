package BookMyShow.models;

import java.util.List;

public class Screen {
    private int id;
    private List<Seat> seats;

    public Screen(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }
}
