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
}

