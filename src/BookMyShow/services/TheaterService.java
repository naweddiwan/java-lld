package BookMyShow.services;

import BookMyShow.models.City;
import BookMyShow.models.Movie;
import BookMyShow.models.Show;
import BookMyShow.models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Theatre> getCityTheatres(City city) {
        return cityToTheatreMap.get(city);
    }

    public Map<String, List<Show>> getAllShowsForAMovieInACity(Movie movie, City city){
        List<Theatre> theatres = getCityTheatres(city);
        return theatres.stream()
                .flatMap(theatre -> theatre.getShows().stream()
                        .filter(show -> show.getMovie().getName().equals(movie.getName()))
                        .map(show -> Map.entry(theatre.getName(), show))) // Map theatre name to show
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, // Group by theatre name
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // Collect shows into a list
                ));
    }
}
