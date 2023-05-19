package com.example.travelTrip.service;

import com.example.travelTrip.entity.UserEntity;
import com.example.travelTrip.model.User;
import com.example.travelTrip.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public List<User> getAllUsers(){

        try {
            List<UserEntity> users = repo.findAll();
            List<User> customUsers = new ArrayList<>();
            users.stream().forEach(e -> {
                User user = new User();
                BeanUtils.copyProperties(e, user);
                customUsers.add(user);
            });
            return customUsers;
        }catch(Exception e) {
            throw e;
        }
    }
    public String saveUser(UserEntity user){
        repo.save(user);
        return "User registered Successfully";
    }
    public String removeUser(UserEntity employee) {
        try {
            if (repo.existsByUserNameAndPassword(employee.getFirstName(), employee.getLastName())) {
                repo.delete(employee);
                return "User deleted successfully.";
            } else {
                return "User does not exist.";
            }
        }catch (Exception e) {
            throw e;
        }
    }
}
