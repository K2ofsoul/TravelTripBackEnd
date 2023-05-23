package com.example.travelTrip.repo;

import com.example.travelTrip.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<EventEntity,Integer> {
}
