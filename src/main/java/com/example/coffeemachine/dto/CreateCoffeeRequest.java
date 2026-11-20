package com.example.coffeemachine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateCoffeeRequest {

    @NotBlank(message = "Name cannot be blank")
    String name;
    String description;
    @Positive(message = "Price must be positive")
    Float price;
}
