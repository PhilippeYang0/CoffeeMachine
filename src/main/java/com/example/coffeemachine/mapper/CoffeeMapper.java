package com.example.coffeemachine.mapper;

import com.example.coffeemachine.dto.CoffeeDTO;
import com.example.coffeemachine.dto.CreateCoffeeRequest;
import com.example.coffeemachine.dto.UpdateCoffeeRequest;
import com.example.coffeemachine.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    CoffeeDTO toDto(Coffee coffee);

    CoffeeDTO toDto(CreateCoffeeRequest request);

    CoffeeDTO toDto(UpdateCoffeeRequest request);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeDTO dto);

}

