package com.example.travelTrip.controller;

import com.example.travelTrip.entity.HotelEntity;
import com.example.travelTrip.entity.RestaurantEntity;
import com.example.travelTrip.service.HotelService;
import com.example.travelTrip.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelService service;
    @GetMapping("getHotel")
    public ResponseEntity<HotelEntity> getHotelById(@PathVariable int id) {
        return service.getHotelById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveHotel")
    private ResponseEntity<String> saveHotel(@RequestParam("image") MultipartFile image,
                                                  @RequestParam("Hotel_ID") int Hotel_ID,
                                                  @RequestParam("Hotel_Name") String Hotel_Name,
                                                  @RequestParam("Country_ID") int Country_ID,
                                                  @RequestParam("Hotel_Star")int Hotel_Star,
                                                  @RequestParam("Hotel_Person")String Hotel_Person,
                                                    @RequestParam("Hotel_Description")String Hotel_Description) {
        try {
            byte[] imageData = image.getBytes();
            HotelEntity place = new HotelEntity();
            place.setHotelID(Hotel_ID);
            place.setName(Hotel_Name);
            place.setCountryID(Country_ID);
            place.setStar(Hotel_Star);
            place.setPerson(Hotel_Person);
            place.setDescription(Hotel_Description);
            place.setImage(imageData);

            service.saveHotel(place);

            return new ResponseEntity<>("Hotel saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteHotel")
    public ResponseEntity<Void> deleteHotel(@PathVariable int id) {
        service.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
