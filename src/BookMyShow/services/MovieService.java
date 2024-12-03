package BookMyShow.services;

import BookMyShow.models.City;
import BookMyShow.models.Movie;
import BookMyShow.models.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    Map<City, List<Movie>> cityToMoviesMap;
    List<Movie> movieList;

    public MovieService(){
        cityToMoviesMap = new HashMap<>();
        movieList = new ArrayList<>();
    }

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
