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
public class AreaEntity {
    @ManyToOne
    @JoinColumn(name = "City_ID", referencedColumnName = "City_ID")
    private CityEntity city = new CityEntity();
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
    @JsonProperty("City_ID")
    public void setCityID(int City_ID){
        this.city = new CityEntity();
        this.city.setCityID(City_ID);
    }

}
