package com.example.movieratingsw.Service;

import com.example.movieratingsw.Model.Director;
import com.example.movieratingsw.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
    public List<Director> getDirector() {
        return directorRepository.findAll();
    }
    public void addDirector(Director director) {
        directorRepository.save(director);
    }
    public boolean updateDirector(Integer id, Director director) {
        Director oldDirector = directorRepository.getById(id);

        if (!directorRepository.existsById(id)) {
            return false;
        }
        oldDirector.setName(director.getName());
       directorRepository.save(oldDirector);
        return true;
    }
    public boolean deleteDirector(Integer id) {
        Director director = directorRepository.getById(id);
        if (!directorRepository.existsById(id)) {
            return false;
        }
        directorRepository.delete(director);
        return true;
    }


}
