package com.example.travelTrip.repo;

import com.example.travelTrip.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<CityEntity,Integer> {
}
