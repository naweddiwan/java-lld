package BookMyShow.models;

public class Show {
    private int id;
    private Movie movie;
    private Screen screen;
    private int startTime;

    public Show(int id, Movie movie, Screen screen, int startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getId() {
        return id;
    }

    public Screen getScreen() {
        return screen;
    }
}
