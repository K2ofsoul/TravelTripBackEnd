package com.example.travelTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel_tab")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Hotel_ID;
    public String Hotel_Name;
    public int Country_ID;
    public int Hotel_Star;
    public String Hotel_Person;
    public String Hotel_Description;
}

