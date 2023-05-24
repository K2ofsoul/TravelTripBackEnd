package com.example.travelTrip.controller;

import com.example.travelTrip.entity.CityEntity;
import com.example.travelTrip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityService service;
    @GetMapping("getCity")
    public ResponseEntity<CityEntity> getCityById(@PathVariable int id) {
        return service.getCityById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveCity")
    private ResponseEntity<String> saveTaiwan(@RequestParam("image") MultipartFile image,
                                              @RequestParam("City_ID") int City_ID,
                                              @RequestParam("City_Name") String City_Name,
                                              @RequestParam("City_Code") int City_Code,
                                              @RequestParam("City_Description")String City_Description) {
        try {
            byte[] imageData = image.getBytes();
            CityEntity place = new CityEntity();
            place.setCityID(City_ID);
            place.setName(City_Name);
            place.setCode(City_Code);
            place.setDescription(City_Description);
            place.setImage(imageData);

            service.saveCity(place);


            return new ResponseEntity<>("City saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("deleteCity")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        service.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
