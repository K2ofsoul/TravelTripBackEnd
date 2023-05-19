package com.example.travelTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "touristDestination_tab")
public class TouristDestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Destination_ID;
    private String Destination_name;

    private Integer Country_ID;


}
