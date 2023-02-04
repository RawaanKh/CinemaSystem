package com.example.movieratingsw.Controller;
import com.example.movieratingsw.Exception.ApiException;
import com.example.movieratingsw.Model.Director;
import com.example.movieratingsw.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/MovieSW")
public class DirectorController {
    final private DirectorService directorService;
    @GetMapping("/getDirector")
    public ResponseEntity getDirector(){
        List<Director> directors = directorService.getDirector();
        return ResponseEntity.status(200).body(directors);
    }
    @PostMapping("/addDirector")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director Added");
    }
    @PutMapping("/updateDirector/{id}")
    public ResponseEntity updateDirector(@Valid @RequestBody Director director, @PathVariable Integer id) {
        boolean isValid = directorService.updateDirector(id, director);
        if (isValid) {
            return ResponseEntity.status(200).body("director is updated ");
        }
        throw new ApiException("Id not Found");
    }
    @DeleteMapping("/deleteDirector/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        boolean isValid = directorService.deleteDirector(id);
        if(isValid){
            return ResponseEntity.status(200).body("director deleted ");
        }
        throw new ApiException("Id not Found");
    }
}
