package com.example.travelTrip.service.Country;

import com.example.travelTrip.entity.Country.TaiwanEntity;
import com.example.travelTrip.entity.Country.VietnamEntity;
import com.example.travelTrip.repo.Country.TaiwanRepo;
import com.example.travelTrip.repo.Country.VietnamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaiwanService {
    private final TaiwanRepo repo;

    @Autowired
    public TaiwanService(TaiwanRepo repo) {
        this.repo = repo;
    }

    public List<TaiwanEntity> getTaiwan() {
        return repo.findAll();
    }

    public Optional<TaiwanEntity> getPlaceById(Long id) {
        return repo.findById(id);
    }

    public String saveTaiwan(TaiwanEntity place) {
        repo.save(place);
        return "save place successfully";
    }

    public void deleteTaiwan(Long id) {
        repo.deleteById(id);
    }
}
