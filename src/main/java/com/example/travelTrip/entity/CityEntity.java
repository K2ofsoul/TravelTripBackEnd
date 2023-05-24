package com.example.travelTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int City_ID;
    private String City_Name;
    private int City_Code;
    private String City_Description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setCityID(int City_ID){
        this.City_ID = City_ID;
    }
    public void setName(String City_Name){
        this.City_Name = City_Name;
    }
    public void setCode(int City_Code){
        this.City_Code = City_Code;
    }
    public void setDescription(String City_Description){
        this.City_Description = City_Description;
    }
}
