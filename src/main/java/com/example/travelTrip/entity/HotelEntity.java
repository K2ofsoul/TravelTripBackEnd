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
    private int Hotel_ID;
    public String Hotel_Name;
    @ManyToOne
    @JoinColumn(name = "Country_ID", referencedColumnName = "Country_ID")
    private CountryEntity country = new CountryEntity();
    public int Hotel_Star;
    public String Hotel_Person;
    public String Hotel_Description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    public void setHotelID(int Hotel_ID){
        this.Hotel_ID = Hotel_ID;
    }
    public void setName(String Hotel_Name){
        this.Hotel_Name = Hotel_Name;
    }
    public void setCountryID(int Country_ID){
        this.country = new CountryEntity();
        this.country.setCountryID(Country_ID);
    }
    public void setStar(int Hotel_Star){
        this.Hotel_Star= Hotel_Star;
    }
    public void setPerson(String Hotel_Person){
        this.Hotel_Person = Hotel_Person;
    }
    public void setDescription(String Hotel_Description){
        this.Hotel_Description = Hotel_Description;
    }
}

