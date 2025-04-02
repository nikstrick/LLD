package BMS.Controller;

import BMS.Entities.Enums.City;
import BMS.Entities.Records.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> movieMap;
    List<Movie> movieList;

    public MovieController() {
        movieMap = new HashMap<>();
        movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        movieList.add(movie);
        if (movieMap.containsKey(city)) {
            movieMap.get(city).add(movie);
        }else{
            movieMap.put(city, new ArrayList<>(List.of(movie)));
        }
    }

    public List<Movie> getMovieListByCity(City city) {
        return movieMap.get(city);
    }

    public Movie getMovieFromList(String movieName) {
        return movieList.stream().filter(m -> m.name().equals(movieName)).findFirst().get();
    }
}
