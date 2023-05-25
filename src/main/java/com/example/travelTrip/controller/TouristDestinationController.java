package com.example.travelTrip.controller;

import com.example.travelTrip.entity.TouristDestinationEntity;
import com.example.travelTrip.service.TouristDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class TouristDestinationController {
    @Autowired
    private TouristDestinationService placeService;

//    @GetMapping
//    public ResponseEntity<List<TouristDestinationEntity>> getAllPlaces() {
//        List<TouristDestinationEntity> places = placeService.getAllPlaces();
//        return new ResponseEntity<>(places, HttpStatus.OK);
//    }

//    @GetMapping("getDestination")
//    public ResponseEntity<TouristDestinationEntity> getDestinationById(@PathVariable int id) {
//        return TouristDestinationService.getDestinationById(id)
//                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping("/saveDestination")
    private ResponseEntity<String> saveDestination(@RequestParam("image") MultipartFile image,
                                                   @RequestParam("Destination_Name") String Destination_Name,
                                                   @RequestParam("Destination_Description") String Destination_Description,
                                                   @RequestParam("Country_ID") int Country_ID,
                                                   @RequestParam("Type_ID") int Type_ID) {
        try {
            byte[] imageData = image.getBytes();
            TouristDestinationEntity place = new TouristDestinationEntity();
            place.setName(Destination_Name);
            place.setDestination(Destination_Description);
            place.setCountryID(Country_ID);
            place.setTypeID(Type_ID);
            place.setImage(imageData);

            placeService.saveDestination(place);


            return new ResponseEntity<>("Place saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("deleteDestination")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        placeService.deleteDestination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
