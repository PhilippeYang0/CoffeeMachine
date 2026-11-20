package com.example.coffeemachine.controller;

import com.example.coffeemachine.dto.CoffeeDTO;
import com.example.coffeemachine.dto.CreateCoffeeRequest;
import com.example.coffeemachine.dto.UpdateCoffeeRequest;
import com.example.coffeemachine.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping("coffees")
    List<CoffeeDTO> coffees(){
        return coffeeService.allCoffees();
    }

    @GetMapping("coffees/{id}")
    CoffeeDTO coffee(@PathVariable Long id){
        return coffeeService.coffeeById(id);
    }

    @PostMapping("coffees")
    @ResponseStatus(HttpStatus.CREATED)
    CoffeeDTO createCoffee(@RequestBody @Valid CreateCoffeeRequest request) {
        return coffeeService.createCoffee(request);
    }

    @PatchMapping("coffees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CoffeeDTO updateCoffee(@RequestBody @Valid UpdateCoffeeRequest request, @PathVariable Long id){
        return coffeeService.updateCoffee(request,id);
    }

    @DeleteMapping("coffees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CoffeeDTO deleteCoffee(@PathVariable Long id){
        return coffeeService.deleteCoffee(id);
    }
}
