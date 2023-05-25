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
@Table(name = "Area_tab")
public class AreaEntity {
    @ManyToOne
    @JoinColumn(name = "Country_ID", referencedColumnName = "Country_ID")
    private CountryEntity country = new CountryEntity();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Area_ID;
    private String Area_Name;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setAreaID(int Area_ID){
        this.Area_ID = Area_ID;
    }
    public void setName(String Area_Name){
        this.Area_Name = Area_Name;
    }
    public void setCountryID(int Country_ID){
        this.country = new CountryEntity();
        this.country.setCountryID(Country_ID);
    }

}
