package com.example.travelTrip.service;

import com.example.travelTrip.entity.CityEntity;
import com.example.travelTrip.entity.CountryEntity;
import com.example.travelTrip.repo.CityRepo;
import com.example.travelTrip.repo.countryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityService {
    private final CityRepo repo;
    @Autowired
    public CityService(CityRepo repo){
        this.repo = repo;
    }
    public List<CityEntity> getCity() {
        return repo.findAll();
    }

    public Optional<CityEntity> getCityById(int id) {
        return repo.findById(id);
    }

    public String saveCity(CityEntity place) {
        repo.save(place);
        return "save city successfully";
    }

    public void deleteCity(int id) {
        repo.deleteById(id);
    }

}
