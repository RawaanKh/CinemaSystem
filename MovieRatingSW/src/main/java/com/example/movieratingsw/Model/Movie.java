package com.example.movieratingsw.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @NotNull(message = "id should not be empty")
    @Min(value = 3,message = "id must be 3 or longer")
private Integer id;
    @NotEmpty(message = "cannot be empty")
    @Size(min = 2,message = "name must be 2 or longer")
    private  String name;
    @NotEmpty(message = "cannot be empty")
    private String genre;
    @Min(1)
    @Max(5)
    private Double rating;
     @Min(60)
    private Integer duration;
     @NotNull(message = "cannot be empty")
     private Integer directorId;
}
