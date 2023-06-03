package com.example.watchListAssig.Service;

import com.example.watchListAssig.MovieEntity.Director;
import com.example.watchListAssig.MovieEntity.Movie;
import com.example.watchListAssig.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovieInDb(Movie movie){
        movieRepository.addMovieInDb(movie);
    }

    public void addDirectorInDb(Director director){
        movieRepository.addDirectorInDb(director);
    }
    public void addPair(String movieName, String directorName){
        movieRepository.addPair(movieName, directorName);
    }
    public Movie getMovie(String movieName){
        return movieRepository.getMovie(movieName);
    }
    public Director getDirector(String director){
        return movieRepository.getDirector(director);
    }

    public List<String> getMovieList(String directorName){
        return movieRepository.getListOfAllMoviesFromDb(directorName);
    }
    public List<String> getAllMovies(){
        return movieRepository.getMovieListFromDb();
    }

    public void deleteList(String directorName) {
        movieRepository.deletMovieList(directorName);
    }
    public void deleteAll(){
        movieRepository.deleteAllDirectorsMovie();
    }
}
