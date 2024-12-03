package BookMyShow.models;

import BookMyShow.enums.BookingStatus;

import java.util.List;

public class Booking {
    private int id;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;

    private static int numBookings = 0;

    public Booking(List<Seat> seats, Show show) {
        this.seats = seats;
        this.show = show;
        this.id = ++numBookings;
        this.status = BookingStatus.CREATED;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }
    public boolean isBookingConfirmed(){
        return status == BookingStatus.CONFIRMED;
    }

    public int getId() {
        return id;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
