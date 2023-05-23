package com.example.travelTrip.controller;

import com.example.travelTrip.entity.UserEntity;
import com.example.travelTrip.model.User;
import com.example.travelTrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestBody UserEntity user){
        //save the user
        String msg = service.saveUser(user);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
//    @RequestMapping(value = "getallusers",  method = RequestMethod.GET)
//    public List<User> getAllUsers(){
//        return service.getAllUsers();
//    }
//    @RequestMapping(value="deleteusers",method = RequestMethod.DELETE)
//    public String removeUser(@RequestBody UserEntity user){
//        return service.removeUser(user);
//    }
    @GetMapping("/getallusers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
}
