package BookMyShow.services;

import BookMyShow.models.City;
import BookMyShow.models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterService {
    private Map<City, List<Theatre>> cityToTheatreMap;
    private List<Theatre> theatres;

    public TheaterService(){
        cityToTheatreMap = new HashMap<>();
        theatres = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        theatres.add(theatre);
        List<Theatre> theatreList = cityToTheatreMap.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        cityToTheatreMap.put(city, theatreList);
    }

    public List<Theatre> getAllTheatres() {
        return this.theatres;
    }
}
