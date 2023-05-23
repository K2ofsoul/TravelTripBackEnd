package com.example.travelTrip.service;


import com.example.travelTrip.entity.Country.VietnamEntity;
import com.example.travelTrip.repo.Country.VietnamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VietnamService {
    private final VietnamRepo repo;

    @Autowired
    public VietnamService(VietnamRepo repo) {
        this.repo = repo;
    }

    public List<VietnamEntity> getVietnam() {
        return repo.findAll();
    }

    public Optional<VietnamEntity> getPlaceById(Long id) {
        return repo.findById(id);
    }

    public String saveVietnam(VietnamEntity place) {
        repo.save(place);
        return "save place successfully";
    }

    public void deleteVietnam(Long id) {
        repo.deleteById(id);
    }
}
