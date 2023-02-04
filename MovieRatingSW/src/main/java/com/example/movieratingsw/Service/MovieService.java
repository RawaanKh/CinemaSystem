package com.example.movieratingsw.Service;

import com.example.movieratingsw.Exception.ApiException;
import com.example.movieratingsw.Model.Director;
import com.example.movieratingsw.Model.Movie;
import com.example.movieratingsw.Repository.DirectorRepository;
import com.example.movieratingsw.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public boolean updateMovie(Integer id, Movie movie) {
        Movie oldMovie = movieRepository.getById(id);

        if (!movieRepository.existsById(id)) {
            return false;
        }
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());
        movieRepository.save(oldMovie);
        return true;
    }
    public boolean deleteMovie(Integer id) {
        Movie movie = movieRepository.getById(id);
        if (!movieRepository.existsById(id)) {
            return false;
        }
        movieRepository.delete(movie);
        return true;
    }
    public Movie findMovieByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null) {
            throw new ApiException("Movie is not found");
        }
        return movie;
    }
    public Movie findMovieByDuration(Integer duration) {
        Movie movie = movieRepository.findMovieByDuration(duration);
        if (movie == null) {
            throw new ApiException("Movie is not found");
        }
        return movie;
    }
    public Movie findMovieRating(String name) {
        Movie movie = movieRepository.findMovieRating(name);
        if (movie == null) {
            throw new ApiException("Movie is not found");
        }
        return movie;
    }
    public List<Movie> findAllByRate(Double rating){
        List<Movie> movies = movieRepository.findAllByRateGreaterThan(rating);
        if (movies.isEmpty()){
            throw new ApiException("Movie is not found");
        }
        return movies;
    }
    public List<Movie> findAllByGenre(String genre){
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if (movies.isEmpty()){
            throw new ApiException("There's no movies whiten selected genre");
        }
        return movies;
    }
    public List<Movie> findAllByDirectorID(Integer id){
        List<Movie> movies = movieRepository.findAllByDirectorID(id);
        if (movies.isEmpty()){
            throw new ApiException("there is no movies by this director");
        }
        return movies;
    }
    public String findDirectorByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie==null){
            throw new ApiException("movie is not found");
        }
        Director DirectorName = directorRepository.findDirectorById(movie.getDirectorId());
        return DirectorName.getName();
    }
}