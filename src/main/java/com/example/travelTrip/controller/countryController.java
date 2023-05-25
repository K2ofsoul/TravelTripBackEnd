package com.example.travelTrip.controller;

import com.example.travelTrip.entity.Country.TaiwanEntity;
import com.example.travelTrip.entity.CountryEntity;
import com.example.travelTrip.service.Country.TaiwanService;
import com.example.travelTrip.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class countryController {
    @Autowired
    private CountryService service;

//    @GetMapping
//    public ResponseEntity<List<VietnamEntity>> getVietnamPlaces() {
//        List<VietnamEntity> places = service.getVietnam();
//        return new ResponseEntity<>(places, HttpStatus.OK);
//    }

    @GetMapping("/getCountry")
    public ResponseEntity<CountryEntity> getPlaceById(@PathVariable int id) {
        return service.getPlaceById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveCountry")
    private ResponseEntity<String> saveTaiwan(@RequestParam("image") MultipartFile image,
                                              @RequestParam("Country_ID") int Country_ID,
                                              @RequestParam("Country_Name") String Country_Name) {
        try {
            byte[] imageData = image.getBytes();
            CountryEntity place = new CountryEntity();
            place.setName(Country_Name);
            place.setCountryID(Country_ID);
            place.setImage(imageData);

            service.saveCountry(place);


            return new ResponseEntity<>("Place saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteCountry")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        service.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
