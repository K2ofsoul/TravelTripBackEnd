package com.example.travelTrip.service;

import com.example.travelTrip.entity.AreaEntity;
import com.example.travelTrip.entity.HotelEntity;
import com.example.travelTrip.repo.AreaRepo;
import com.example.travelTrip.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HotelService {
    private final HotelRepo repo;
    @Autowired
    public HotelService(HotelRepo repo){
        this.repo = repo;
    }
    public List<HotelEntity> getHotel() {
        return repo.findAll();
    }

    public Optional<HotelEntity> getHotelById(int id) {
        return repo.findById(id);
    }

    public String saveHotel(HotelEntity place) {
        repo.save(place);
        return "save hotel successfully";
    }

    public void deleteHotel(int id) {
        repo.deleteById(id);
    }

}
