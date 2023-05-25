package com.example.travelTrip.service;

import com.example.travelTrip.entity.RestaurantEntity;
import com.example.travelTrip.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepo placeRepository;

    @Autowired
    public RestaurantService(RestaurantRepo placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<RestaurantEntity> getAllRestaurant() {
        return placeRepository.findAll();
    }

    public Optional<RestaurantEntity> getRestaurantById(int id) {
        return placeRepository.findById(id);
    }

    public String saveRestaurant(RestaurantEntity place) {
        placeRepository.save(place);
        return "save restaurant successfully";
    }

    public void deleteRestaurant(int id) {
        placeRepository.deleteById(id);
    }
}
