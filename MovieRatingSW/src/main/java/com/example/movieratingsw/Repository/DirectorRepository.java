package com.example.movieratingsw.Repository;

import com.example.movieratingsw.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
Director findDirectorById(Integer id);
}
