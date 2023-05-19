package com.example.travelTrip.repo;

import com.example.travelTrip.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    public boolean existsByUserNameAndPassword(String firstName,  String lastName);

    public boolean existsById(int id);

}
