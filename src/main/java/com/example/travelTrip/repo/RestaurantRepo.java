package com.example.travelTrip.repo;

import com.example.travelTrip.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<RestaurantEntity,Integer> {
}
