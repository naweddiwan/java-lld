package BookMyShow.services;

import BookMyShow.models.City;
import BookMyShow.models.Movie;
import BookMyShow.models.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieService {

    @Builder.Default
    private Map<City, List<Movie>> cityToMoviesMap = new HashMap<>();
    @Builder.Default
    List<Movie> movieList = new ArrayList<>();

    public void addMovie(Movie movie, City city){
        movieList.add(movie);
        List<Movie> movies = cityToMoviesMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityToMoviesMap.put(city,  movies);
    }

    public List<Movie> getAllMovies() {
        return this.movieList;
    }

    public List<Movie> getAllMoviesInCity(City city){
        return cityToMoviesMap.get(city);
    }
}
