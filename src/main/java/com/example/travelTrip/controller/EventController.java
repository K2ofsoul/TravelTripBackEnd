package com.example.travelTrip.controller;

import com.example.travelTrip.entity.EventEntity;
import com.example.travelTrip.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventController {
    @Autowired
    private EventService service;
    @PostMapping("/saveEvent")
    private ResponseEntity<String> saveEvent(@RequestBody EventEntity event){
        String msg = service.saveEvent(event);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
