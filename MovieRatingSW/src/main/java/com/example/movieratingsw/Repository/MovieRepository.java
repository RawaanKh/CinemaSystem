package com.example.movieratingsw.Repository;

import com.example.movieratingsw.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

 Movie findMovieByName(String name);
Movie findMovieByDuration(Integer duration);
 List<Movie> findAllByGenre(String genre);
Movie findMovieRating(String name);
 List<Movie> findAllByRateGreaterThan(Double rating);
 List<Movie> findAllByDirectorID(Integer directorId);

}
