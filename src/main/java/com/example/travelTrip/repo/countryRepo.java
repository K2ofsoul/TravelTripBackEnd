package com.example.travelTrip.repo;

import com.example.travelTrip.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface countryRepo extends JpaRepository<CountryEntity,Integer> {
}
