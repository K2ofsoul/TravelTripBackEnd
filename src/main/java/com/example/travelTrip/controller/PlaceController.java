package com.example.travelTrip.controller;

import com.example.travelTrip.entity.EventEntity;
import com.example.travelTrip.entity.PlaceEntity;
import com.example.travelTrip.repo.PlaceRepo;
import com.example.travelTrip.service.PlaceService;
import com.example.travelTrip.service.UserService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceEntity>> getAllPlaces() {
        List<PlaceEntity> places = placeService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("getPlace")
    public ResponseEntity<PlaceEntity> getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/savePlace")
    private ResponseEntity<String> savePlace(@RequestParam("image") MultipartFile image, @RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("description") String description) {
        try {
            // Lưu dữ liệu hình ảnh vào trường image của Place
            byte[] imageData = image.getBytes();

            // Tạo đối tượng Place và gán các giá trị
            PlaceEntity place = new PlaceEntity();
            place.setName(name);
            place.setLocation(location);
            place.setDescription(description);
            place.setImage(imageData);

            placeService.savePlace(place);


            return new ResponseEntity<>("Place saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("deletePlace")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
