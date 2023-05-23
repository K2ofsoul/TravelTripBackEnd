package com.example.travelTrip.controller.Country;

import com.example.travelTrip.entity.Country.TaiwanEntity;
import com.example.travelTrip.service.Country.TaiwanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@CrossOrigin
public class TaiwanController {
    @Autowired
    private TaiwanService service;

//    @GetMapping
//    public ResponseEntity<List<VietnamEntity>> getVietnamPlaces() {
//        List<VietnamEntity> places = service.getVietnam();
//        return new ResponseEntity<>(places, HttpStatus.OK);
//    }

    @GetMapping("getTaiwan")
    public ResponseEntity<TaiwanEntity> getPlaceById(@PathVariable Long id) {
        return service.getPlaceById(id)
                .map(place -> new ResponseEntity<>(place, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveTaiwan")
    private ResponseEntity<String> saveTaiwan(@RequestParam("image") MultipartFile image, @RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("description") String description) {
        try {
            // Lưu dữ liệu hình ảnh vào trường image của Place
            byte[] imageData = image.getBytes();

            // Tạo đối tượng Place và gán các giá trị
            TaiwanEntity place = new TaiwanEntity();
            place.setName(name);
            place.setLocation(location);
            place.setDescription(description);
            place.setImage(imageData);

            service.saveTaiwan(place);


            return new ResponseEntity<>("Place saved successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("deleteTaiwan")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        service.deleteTaiwan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
