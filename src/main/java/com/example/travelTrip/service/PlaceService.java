package com.example.travelTrip.service;

import com.example.travelTrip.entity.PlaceEntity;
import com.example.travelTrip.repo.PlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    private final PlaceRepo placeRepository;

    @Autowired
    public PlaceService(PlaceRepo placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceEntity> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Optional<PlaceEntity> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    public String savePlace(PlaceEntity place) {
        placeRepository.save(place);
        return "save place successfully";
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}
