package BookMyShow;

import BookMyShow.enums.SeatCategory;
import BookMyShow.models.*;
import BookMyShow.services.MovieService;
import BookMyShow.services.TheaterService;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {

    public City bangalore;
    MovieService movieService;
    TheaterService theaterService;

    BookMyShow() {
        movieService = new MovieService();
        theaterService = new TheaterService();
        bangalore = new City(1, "Bangalore");
    }
    public static void main(String[] args) {

        BookMyShow bms = new BookMyShow();
        bms.addMovies();
        bms.addTheatres();

        System.out.println("Movies _____");
        for(Movie m: bms.movieService.getAllMovies()){
            System.out.println(m.getName());
        }
        System.out.println("Theatres _____");
        for(Theatre t: bms.theaterService.getAllTheatres()){
            System.out.println("Theatre: "+ t.getName());
            for(Show s: t.getShows()){
                System.out.println("Movie : " + s.getMovie().getName() + " | Show Time: " + s.getStartTime());
            }
        }

        // Search Movie by City


    }

    public void addMovies() {
        Movie harryPotter = new Movie(1, "Harry Potter");
        Movie spiderMan = new Movie(1, "Spider Man");
        movieService.addMovie(harryPotter, bangalore);
        movieService.addMovie(spiderMan, bangalore);
    }

    public void addTheatres() {
        List<Seat> seats1 = getSeats();
        Screen screen1 = new Screen(1, seats1);

        List<Seat> seats2 = getSeats();
        Screen screen2 = new Screen(1, seats2);

        List<Screen> screens = new ArrayList<>();
        screens.add(screen1);
        screens.add(screen2);

        Theatre nexus = new Theatre(1, "Nexus, Kormangla", screens, "Nexus");

        List<Show> shows = getShows(screens);
        nexus.addShows(shows);

        theaterService.addTheatre(bangalore, nexus);
    }
    private List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=1; i<=10; i++) {
            Seat seat = new Seat(i,1, SeatCategory.STANDARD);
            seats.add(seat);
        }
        for(int i=11; i<=20; i++) {
            Seat seat = new Seat(i,2, SeatCategory.PREMIUM);
            seats.add(seat);
        }
        for(int i=21; i<=30; i++) {
            Seat seat = new Seat(i,3, SeatCategory.RECLINER);
            seats.add(seat);
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
