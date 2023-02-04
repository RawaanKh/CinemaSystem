package com.example.movieratingsw.Controller;

import com.example.movieratingsw.Exception.ApiException;
import com.example.movieratingsw.Model.Movie;
import com.example.movieratingsw.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/MovieSW")
public class MovieController {
final private MovieService movieService;
    @GetMapping("/getMovie")
    public ResponseEntity getMovie(){
        List<Movie> movies = movieService.getMovie();
        return ResponseEntity.status(200).body(movies);
    }
    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }
    @PutMapping("/updateMovie/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id) {
        boolean isValid = movieService.updateMovie(id, movie);
        if (isValid) {
            return ResponseEntity.status(200).body("movie is updated ");
        }
        throw new ApiException("Id not Found");
    }
    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        boolean isValid = movieService.deleteMovie(id);
        if(isValid){
            return ResponseEntity.status(200).body("movie deleted ");
        }
        throw new ApiException("Id not Found");
    }
    //1
    @GetMapping("/getByName/{name}")
     public ResponseEntity getByName(@PathVariable String name){
        Movie movie=movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(name);
    }
    //2
    @GetMapping("/getByDuration/{duration}")
    public ResponseEntity getByDuration(@PathVariable Integer duration){
        Movie movie=movieService.findMovieByDuration(duration);
        return ResponseEntity.status(200).body(duration);
    }
    //5
    @GetMapping("/getMovieRating/{name}")
    public ResponseEntity getByRating(@PathVariable String name){
        Movie movie=movieService.findMovieRating(name);
        return ResponseEntity.status(200).body(name);
    }
    //7
    @GetMapping("/getMovieByGenre/{genre}")
    public ResponseEntity getMovieByRate(@PathVariable String genre ){
        List<Movie> movies =movieService.findAllByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }
    //4
    @GetMapping("/getMovieByDirectorId/{id}")
    public ResponseEntity getMovieByDirectorId(@PathVariable Integer id ){
        List<Movie> movies =movieService.findAllByDirectorID(id);
        return ResponseEntity.status(200).body(movies);
    }
    //3
    @GetMapping("/getDirectorByMovieName/{name}")
    public ResponseEntity getMovieByMovieName(@PathVariable String name ){
        String DName = movieService.findDirectorByName(name);
        return ResponseEntity.status(200).body(DName);
    }
    //6
    @GetMapping("/getMovieByRate/{rating}")
    public ResponseEntity getMovieByRate(@PathVariable Double rating ){
        List<Movie> movies = movieService.findAllByRate(rating);
        return ResponseEntity.status(200).body(movies);
    }
}
