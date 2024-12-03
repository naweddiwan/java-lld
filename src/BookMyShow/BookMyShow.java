package BookMyShow;

import BookMyShow.enums.SeatCategory;
import BookMyShow.models.*;
import BookMyShow.services.BookingService;
import BookMyShow.services.MovieService;
import BookMyShow.services.TheaterService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    City bangalore;
    City delhi;
    MovieService movieService;
    TheaterService theaterService;
    BookingService bookingService;

    BookMyShow() {
        movieService = new MovieService();
        theaterService = new TheaterService();
        bookingService = new BookingService();
        bangalore = new City(1, "Bangalore");
        delhi = new City(2, "New Delhi");

    }
    public static void main(String[] args) {

        BookMyShow bms = new BookMyShow();
        bms.addMovies();
        bms.addTheatres();


        List<Movie> movies = bms.movieService.getAllMoviesInCity(bms.bangalore);
        System.out.println("Movies in Bangalore");
        for(Movie m: movies) {
            System.out.println(m.getName());
        }
        System.out.println();
        Movie selectedMovie = movies.get(0);
       Map<String, List<Show>> showsForSelectedMovie = bms.theaterService.getAllShowsForAMovieInACity(selectedMovie, bms.bangalore);
        System.out.println("Shows for selected movie: " + selectedMovie.getName());
        for(String theatre: showsForSelectedMovie.keySet()){
            System.out.println("Theatre : " + theatre );
            System.out.println("SHOWS: ");
            for(Show show: showsForSelectedMovie.get(theatre)){
                System.out.println("START TIME: " + show.getStartTime());
            }
        }
        System.out.println();

        Show selectedShow = showsForSelectedMovie.get("Nexus").get(0);
        System.out.println("Selected Show: " + selectedShow.getStartTime() );
        System.out.println();
        List<Seat> freeSeats = selectedShow.getScreen().getFreeSeats();

        System.out.println("AVAILABLE SEATS");
        for(Seat seat: freeSeats) {
            System.out.println(seat.seatDetails());
        }
        System.out.println();

        List<Seat> bookSeats = freeSeats.subList(0, 5);


        bms.bookingService.createBooking(bookSeats, 1, selectedShow);

        freeSeats = selectedShow.getScreen().getFreeSeats();


        System.out.println("AVAILABLE SEATS after Booking");
        for(Seat seat: freeSeats) {
            System.out.println(seat.seatDetails());
        }
        System.out.println();

        Booking booking = bms.bookingService.getBooking(1);
        System.out.println(booking.getShow().getMovie().getName()+ " " + booking.isBookingConfirmed());
    }



    public void addMovies() {
        Movie harryPotter = new Movie(1, "Harry Potter");
        Movie spiderMan = new Movie(1, "Spider Man");
        Movie ironMan = new Movie(1, "Iron Man");
        movieService.addMovie(harryPotter, bangalore);
        movieService.addMovie(spiderMan, bangalore);
        movieService.addMovie(ironMan, delhi);
    }

    public void addTheatres() {
        Map<Integer, Seat> seats1= getSeats();
        Screen screen1 = new Screen(1, seats1);

        Map<Integer, Seat>  seats2= getSeats();
        Screen screen2 = new Screen(2, seats2);

        List<Screen> screens = new ArrayList<>();
        screens.add(screen1);
        screens.add(screen2);

        Theatre nexus = new Theatre(1, "Nexus, Kormangla", screens, "Nexus");

        List<Show> shows = getShows(screens);
        nexus.addShows(shows);

        theaterService.addTheatre(bangalore, nexus);

        Map<Integer, Seat> seats3= getSeats();
        Screen screen3 = new Screen(3, seats3);
        List<Screen> screens2 = new ArrayList<>();
        screens2.add(screen3);
        Theatre dlf = new Theatre(1, "DLF, Noida", screens2, "DLF");

        List<Show> shows2= getShows(screens2);
        dlf.addShows(shows2);
        theaterService.addTheatre(delhi, dlf);
    }
    private Map<Integer, Seat> getSeats() {
        Map<Integer, Seat> seats = new HashMap<>();
        for(int i=1; i<=10; i++) {
            Seat seat = new Seat(i,1, SeatCategory.STANDARD);
            seats.put(i, seat);
        }
        for(int i=11; i<=20; i++) {
            Seat seat = new Seat(i,2, SeatCategory.PREMIUM);
            seats.put(i, seat);
        }
        for(int i=21; i<=30; i++) {
            Seat seat = new Seat(i,3, SeatCategory.RECLINER);
            seats.put(i, seat);
        }
        return seats;
    }

    private List<Show> getShows(List<Screen> screens){
        List<Show> shows = new ArrayList<>();
        List<Movie> movies = movieService.getAllMovies();

        Show morningShow = new Show(1,  movies.get(0), screens.get(0),  800);
        shows.add(morningShow);
        return shows;
    }
}
