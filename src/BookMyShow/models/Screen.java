package BookMyShow.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Data
@AllArgsConstructor
public class Screen {
    private int id;
    private Map<Integer, Seat> seats;

    public List<Seat> getFreeSeats() {
        return seats.values().
                stream().
                filter(Seat::isSeatEmpty).
                toList();
    }
}
