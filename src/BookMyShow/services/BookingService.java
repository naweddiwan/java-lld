package BookMyShow.services;

import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.SeatStatus;
import BookMyShow.exceptions.NotFoundException;
import BookMyShow.exceptions.SeatAlreadyBookedException;
import BookMyShow.models.Booking;
import BookMyShow.models.Seat;
import BookMyShow.models.Show;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BookingService {
    Map<Integer, Booking> bookings;

    public BookingService() {
        this.bookings = new HashMap<>();
    }

    public Booking getBooking(int bookingID){
        if(bookings.containsKey(bookingID)){
            return bookings.get(bookingID);
        }
        throw new NotFoundException("BookingID not found");
    }

    public synchronized Booking createBooking(List<Seat> seats, int userID, Show show){
        if(isAnySeatAlreadyBooked(seats, show)){
            throw new SeatAlreadyBookedException();
        }
        System.out.println("Booked Seats : ");
        for(Seat seat: seats){
            System.out.print(seat.getId() + " ");
           seat.setSeatStatus(SeatStatus.BOOKED);
        }
        System.out.println();
        Booking booking = new Booking(seats, show);
        booking.setStatus(BookingStatus.CONFIRMED);
        bookings.put(booking.getId(), booking);
        return booking;
    }

    private Boolean isAnySeatAlreadyBooked(List<Seat> seats, Show show){
        List<Seat> bookedSeats = getAllBookedSeats(show);
        for (Seat seat: seats){
            if(bookedSeats.contains(seat)){
                return true;
            }
        }
        return false;
    }
    private List<Seat> getAllBookedSeats(Show show){
        List<Booking> bookingsForAShow = bookings.values().
                stream().
                filter(booking -> booking.getShow().getId() == show.getId()).
                toList();

       return bookingsForAShow.stream()
               .filter(Booking::isBookingConfirmed)
               .map(Booking::getSeats)
               .flatMap(Collection::stream)
               .toList();
    }


}
