package com.example.travelTrip.service;

import com.example.travelTrip.entity.EventEntity;
import com.example.travelTrip.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepo repo;
    public String saveEvent(EventEntity event){
        repo.save(event);
        return "Save event successfully";
    }
}
