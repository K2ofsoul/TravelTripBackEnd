package com.example.travelTrip.repo;

import com.example.travelTrip.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo extends JpaRepository<TypeEntity,Integer> {
}
