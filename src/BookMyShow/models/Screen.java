package BookMyShow.models;

import java.util.List;
import java.util.Map;

public class Screen {
    private int id;
    private Map<Integer, Seat> seats;

    public Screen(int id, Map<Integer, Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    public  Map<Integer, Seat> getSeats() {
        return seats;
    }

    public List<Seat> getFreeSeats() {
        return seats.values().
                stream().
                filter(Seat::isSeatEmpty).
                toList();
    }
}
