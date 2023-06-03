package com.example.watchListAssig.Repository;

import com.example.watchListAssig.MovieEntity.Director;
import com.example.watchListAssig.MovieEntity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class MovieRepository {

    Map<String, Movie> movies = new HashMap<>();
    Map<String, Director> directors = new HashMap<>();
    Map<String, String> movieDirectorPair = new HashMap<>();

    public void addMovieInDb(Movie movie){
        movies.put(movie.getName(), movie);
    }

    public void addDirectorInDb(Director director) {
        directors.put(director.getName(), director);
    }

    public void addPair(String movieName, String directorName) {
        movieDirectorPair.put(movieName, directorName);
    }


    public Movie getMovie(String movieName) {
        return movies.get(movieName);
    }

    public Director getDirector(String director) {
        return directors.get(director);
    }

    public List<String> getListOfAllMoviesFromDb(String directorName) {
        List<String> listOfMovie = new ArrayList<>();
        for(String movieName : movieDirectorPair.keySet()){
            if (movieDirectorPair.get(movieName).equals(directorName)) {

                listOfMovie.add(movieName);
            }
        }
        return listOfMovie;
    }

    public List<String> getMovieListFromDb() {
        List<String> movieList = new ArrayList<>();
        for(String movieName : movies.keySet()){
            movieList.add(movieName);
        }
        return movieList;
    }

    public void deletMovieList(String directorName) {
        for(String movieName : movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movieName) == directorName) {
                if (movies.containsKey(movieName)) {
                    movies.remove(movieName);
                }
                if (directors.containsKey(directorName)) {
                    directors.remove(directorName);
                }
            }
        }
    }

    public void deleteAllDirectorsMovie() {
        for (String movieName: movieDirectorPair.keySet()){
            if(movies.containsKey(movieName)){
                movies.remove(movieName);
            }
            if(directors.containsKey(movieDirectorPair.get(movieName))){
                directors.remove(movieDirectorPair.get(movieName));
            }
        }
    }
}
