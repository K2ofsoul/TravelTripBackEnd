package com.example.travelTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant_tab")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Restaurant_ID;
    private String Restaurant_Name;
    @ManyToOne
    @JoinColumn(name = "Country_ID", referencedColumnName = "Country_ID")
    private CountryEntity country = new CountryEntity();
    private int Restaurant_Type;
    private String Restaurant_Description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setResID(int Restaurant_ID){
        this.Restaurant_ID = Restaurant_ID;
    }
    public void setName(String Restaurant_Name){
        this.Restaurant_Name = Restaurant_Name;
    }
    public void setCountryID(int Country_ID){
        this.country = new CountryEntity();
        this.country.setCountryID(Country_ID);
    }
    public void setResType(int Restaurant_Type){
        this.Restaurant_Type = Restaurant_Type;
    }
    public void setResDescription(String Restaurant_Description){
        this.Restaurant_Description = Restaurant_Description;
    }

}
