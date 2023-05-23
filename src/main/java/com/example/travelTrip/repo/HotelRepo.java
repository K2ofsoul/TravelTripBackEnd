package com.example.travelTrip.repo;

import com.example.travelTrip.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<HotelEntity,Integer> {
}
