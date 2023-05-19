package com.example.travelTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //for getter and setter method add lombok anotation
@AllArgsConstructor //lombok annotation
@NoArgsConstructor
@Entity//to create the table
@Table(name = "user_tab") //for the table name
public class UserEntity {
    @Id// for id to be primary key
    //below annotation to auto increment the id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

}
