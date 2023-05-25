package com.example.travelTrip.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Country_tab")

public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Country_ID;
    @Column(name = "Country_Name")
    private String Country_Name;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setCountryID(int Country_ID){
        this.Country_ID = Country_ID;
    }
    public void setName(String Country_Name){
        this.Country_Name = Country_Name;
    }



}
