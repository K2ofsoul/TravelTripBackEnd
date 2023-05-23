package com.example.travelTrip.repo;

import com.example.travelTrip.entity.TouristDestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristDestinationRepo extends JpaRepository<TouristDestinationEntity,Integer> {
}
