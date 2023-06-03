package com.example.watchListAssig.Controller;

import com.example.watchListAssig.MovieEntity.Director;
import com.example.watchListAssig.MovieEntity.Movie;
import com.example.watchListAssig.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovieInDb(movie);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @PostMapping("/add-Director")
    public ResponseEntity addDirector(@RequestBody(required = true)Director director){
        movieService.addDirectorInDb(director);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        movieService.addPair(movieName, directorName);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName){
        return new ResponseEntity(movieService.getMovie(movieName), HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String directorName){
        return new ResponseEntity(movieService.getDirector(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName") String directorName){
        return new ResponseEntity(movieService.getMovieList(directorName), HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        movieService.deleteList(directorName);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("//delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAll();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
