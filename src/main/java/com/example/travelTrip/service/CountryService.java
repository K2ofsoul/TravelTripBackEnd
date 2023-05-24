package com.example.travelTrip.service;

import com.example.travelTrip.entity.Country.TaiwanEntity;
import com.example.travelTrip.entity.CountryEntity;
import com.example.travelTrip.repo.countryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final countryRepo repo;
    @Autowired
    public CountryService(countryRepo repo){
        this.repo = repo;
    }
    public List<CountryEntity> getCountry() {
        return repo.findAll();
    }

    public Optional<CountryEntity> getPlaceById(int id) {
        return repo.findById(id);
    }

    public String saveCountry(CountryEntity place) {
        repo.save(place);
        return "save country successfully";
    }

    public void deleteCountry(int id) {
        repo.deleteById(id);
    }

}
