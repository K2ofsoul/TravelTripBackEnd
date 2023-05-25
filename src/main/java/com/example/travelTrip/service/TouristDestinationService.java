package com.example.travelTrip.service;

import com.example.travelTrip.entity.TouristDestinationEntity;
import com.example.travelTrip.repo.TouristDestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TouristDestinationService {
    private final TouristDestinationRepo placeRepository;

    @Autowired
    public TouristDestinationService(TouristDestinationRepo placeRepository) {
        this.placeRepository = placeRepository;
    }

//    public List<TouristDestinationEntity> getAllPlaces() {
//        return placeRepository.findAll();
//    }

    public  Optional<TouristDestinationEntity> getDestinationById(int id) {
        return placeRepository.findById(id);
    }

    public String saveDestination(TouristDestinationEntity place) {
        placeRepository.save(place);
        return "save destination successfully";
    }

    public void deleteDestination(int id) {
        placeRepository.deleteById(id);
    }
}
