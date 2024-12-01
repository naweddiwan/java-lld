package BookMyShow.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int id;
    private String address;
    private List<Screen> screens;
    private final List<Show> shows;
    private String name;

    public Theatre(int id, String address, List<Screen> screens, String name) {
        this.id = id;
        this.address = address;
        this.screens = screens;
        this.shows = new ArrayList<>();
        this.name = name;
    }

    public void addShows(List<Show> shows){
        this.shows.addAll(shows);
    }

    public List<Screen> getAllScreens(){
        return this.screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public String getName() {
        return name;
    }
}
