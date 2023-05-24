package com.example.travelTrip.service;

import com.example.travelTrip.entity.AreaEntity;
import com.example.travelTrip.entity.CountryEntity;
import com.example.travelTrip.repo.AreaRepo;
import com.example.travelTrip.repo.countryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AreaService {
    private final AreaRepo repo;
    @Autowired
    public AreaService(AreaRepo repo){
        this.repo = repo;
    }
    public List<AreaEntity> getArea() {
        return repo.findAll();
    }

    public Optional<AreaEntity> getAreaById(int id) {
        return repo.findById(id);
    }

    public String saveArea(AreaEntity place) {
        repo.save(place);
        return "save area successfully";
    }

    public void deleteArea(int id) {
        repo.deleteById(id);
    }

}
