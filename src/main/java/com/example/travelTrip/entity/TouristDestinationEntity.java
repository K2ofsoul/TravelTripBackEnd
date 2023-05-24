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
    @ManyToOne
    @JoinColumn(name = "Country_ID", referencedColumnName = "Country_ID")
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "Type_ID", referencedColumnName = "Type_ID")
    private TypeEntity type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Destination_ID")
    private int Destination_ID;
    @Column(name = "Destination_name")
    private String Destination_name;
    @Column(name = "Country_ID",insertable=false, updatable=false)
    private int Country_ID;
    @Column(name = "Type_ID",insertable=false, updatable=false)
    private int Type_ID;
    @Column(name = "Destination_Description")
    private String Destination_Description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    public void setName(String Destination_name){
        this.Destination_name = Destination_name;
    }
    public void setDestination(String Destination_Description){
        this.Destination_Description = Destination_Description;
    }
    public void setCountryID(int Country_ID){
        this.Country_ID = Country_ID;
    }
    public void setTypeID(int Type_ID){
        this.Type_ID = Type_ID;
    }
}
