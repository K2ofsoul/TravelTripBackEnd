package com.example.travelTrip.entity;

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
//    @ManyToOne
//    @JoinColumn(name = "Country_ID", referencedColumnName = "Country_ID")
//    private TouristDestinationEntity destination;
    @ManyToOne
    @JoinColumn(name = "Area_ID", referencedColumnName = "Area_ID")
    private AreaEntity area;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Country_ID",insertable=false, updatable=false)
    private int Country_ID;
    @Column(name = "Country_Name")
    private String Country_Name;
    @Column(name = "Area_ID",insertable=false, updatable=false)
    private int Area_ID;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setCountryID(int Country_ID){
        this.Country_ID = Country_ID;
    }
    public void setName(String Country_Name){
        this.Country_Name = Country_Name;
    }
    public void setAreaID(int Area_ID){
        this.Area_ID = Area_ID;
    }
}
