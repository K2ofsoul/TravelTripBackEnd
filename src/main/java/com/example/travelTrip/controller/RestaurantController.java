package com.example.travelTrip.controller;

import com.example.travelTrip.entity.AreaEntity;
import com.example.travelTrip.entity.RestaurantEntity;
import com.example.travelTrip.service.AreaService;
import com.example.travelTrip.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@CrossOrigin
public class RestaurantController {
    @Autowired
    private RestaurantService service;
    @GetMapping("getRestaurant")
    public ResponseEntity<RestaurantEntity> getRestaurantById(@PathVariable int id) {
        return service.getRestaurantById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveRestaurant")
    private ResponseEntity<String> saveRestaurant(@RequestParam("image") MultipartFile image,
                                              @RequestParam("Restaurant_ID") int Restaurant_ID,
                                              @RequestParam("Restaurant_Name") String Restaurant_Name,
                                              @RequestParam("Country_ID") int Country_ID,
                                                  @RequestParam("Restaurant_Type")int Restaurant_Type,
                                                  @RequestParam("Restaurant_Description")String Restaurant_Description) {
        try {
            byte[] imageData = image.getBytes();
            RestaurantEntity place = new RestaurantEntity();
            place.setResID(Restaurant_ID);
            place.setName(Restaurant_Name);
            place.setCountryID(Country_ID);
            place.setResType(Restaurant_Type);
            place.setResDescription(Restaurant_Description);
            place.setImage(imageData);

            service.saveRestaurant(place);

            return new ResponseEntity<>("Restaurant saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteRestaurant")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id) {
        service.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
