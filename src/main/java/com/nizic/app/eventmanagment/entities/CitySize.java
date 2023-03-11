package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city_size")
public class CitySize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citySizeID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "active", nullable = false)
    private Boolean active;

    public CitySize() {
        super();
    }

    public CitySize(Long citySizeID, String name, Boolean active) {
        this.citySizeID = citySizeID;
        this.name = name;
        this.active = active;
    }

    public Long getCitySizeID() {
        return citySizeID;
    }

    public void setCitySizeID(Long citySizeID) {
        this.citySizeID = citySizeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
