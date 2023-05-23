package com.example.travelTrip.repo;

import com.example.travelTrip.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<PlaceEntity,Long> {
}
