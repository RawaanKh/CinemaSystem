package com.example.movieratingsw.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @NotNull(message = "id should not be empty")
    @Min(value = 3,message = "id must be 3 or longer")
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,message = " name must be 2 or longer")
    private  String name;
}

