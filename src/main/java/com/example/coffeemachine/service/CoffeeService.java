package com.example.coffeemachine.service;

import com.example.coffeemachine.dto.CoffeeDTO;
import com.example.coffeemachine.dto.CreateCoffeeRequest;
import com.example.coffeemachine.dto.UpdateCoffeeRequest;
import com.example.coffeemachine.entity.Coffee;
import com.example.coffeemachine.exception.CoffeeNotFoundException;
import com.example.coffeemachine.mapper.CoffeeMapper;
import com.example.coffeemachine.repository.CoffeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CoffeeMapper coffeeMapper;

    public List<CoffeeDTO> allCoffees(){
        return coffeeRepository.findAll().stream().map(coffeeMapper::toDto).toList();
    }

    public CoffeeDTO coffeeById(Long id) {
        return coffeeRepository.findById(id)
                .map(coffeeMapper::toDto)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    public CoffeeDTO createCoffee(CreateCoffeeRequest request) {
        CoffeeDTO coffeeDTO = coffeeMapper.toDto(request);
        Coffee coffee = coffeeMapper.toEntity(coffeeDTO);
        coffee = coffeeRepository.save(coffee);
        coffeeDTO = coffeeMapper.toDto(coffee);
        return coffeeDTO;
    }

    public CoffeeDTO updateCoffee(UpdateCoffeeRequest request, Long id) {
        CoffeeDTO coffeeDTO = coffeeMapper.toDto(request);
        Coffee newCoffee = coffeeMapper.toEntity(coffeeDTO);
        Coffee coffee = coffeeRepository.findById(id).orElseThrow(()-> new CoffeeNotFoundException(id));
        newCoffee.setId(coffee.getId());
        newCoffee = coffeeRepository.save(newCoffee);
        return coffeeMapper.toDto(newCoffee);
    }

    public CoffeeDTO deleteCoffee(Long id){
        Coffee coffee = coffeeRepository.findById(id).orElseThrow(()-> new CoffeeNotFoundException(id));
        coffeeRepository.deleteById(id);
        return coffeeMapper.toDto(coffee);
    }
}
