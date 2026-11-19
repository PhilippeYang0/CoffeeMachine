package com.example.coffeemachine.dto;

import lombok.Data;

@Data
public class UpdateCoffeeRequest {
    String name;
    String description;
    Float price;
}
