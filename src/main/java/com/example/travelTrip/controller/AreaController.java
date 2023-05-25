package com.example.travelTrip.controller;

import com.example.travelTrip.entity.AreaEntity;
import com.example.travelTrip.entity.CityEntity;
import com.example.travelTrip.service.AreaService;
import com.example.travelTrip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class AreaController {
    @Autowired
    private AreaService service;
    @GetMapping("getArea")
    public ResponseEntity<AreaEntity> getAreaById(@PathVariable int id) {
        return service.getAreaById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveArea")
    private ResponseEntity<String> saveTaiwan(@RequestParam("image") MultipartFile image,
                                              @RequestParam("Area_ID") int Area_ID,
                                              @RequestParam("Area_Name") String Area_Name,
                                              @RequestParam("Country_ID") int Country_ID) {
        try {
            byte[] imageData = image.getBytes();
            AreaEntity place = new AreaEntity();
            place.setAreaID(Area_ID);
            place.setCountryID(Country_ID);
            place.setName(Area_Name);
            place.setImage(imageData);

            service.saveArea(place);

            return new ResponseEntity<>("Area saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteArea")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        service.deleteArea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
