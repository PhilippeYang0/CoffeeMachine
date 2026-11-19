package com.example.coffeemachine.repository;

import com.example.coffeemachine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {}
