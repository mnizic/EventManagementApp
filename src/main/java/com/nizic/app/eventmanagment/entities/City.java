package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityID;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizationalunitid", referencedColumnName = "organizationalunitid", nullable = false)
    private OrganizationalUnit organizationalUnit;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "citysizeid", referencedColumnName = "citysizeid", nullable = false)
    private CitySize citySize;

    public City() {
        super();
    }

    public City(Long cityID, String name, OrganizationalUnit organizationalUnitID, CitySize citySize) {
        this.cityID = cityID;
        this.name = name;
        this.organizationalUnit = organizationalUnit;
        this.citySize = citySize;
    }

    public Long getCityID() {
        return cityID;
    }

    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationalUnit getOrganizationalUnitID() {
        return organizationalUnit;
    }

    public void setOrganizationalUnitID(OrganizationalUnit organizationalUnitID) {
        this.organizationalUnit = organizationalUnit;
    }

    public CitySize getCitySize() {
        return citySize;
    }

    public void setCitySize(CitySize citySize) {
        this.citySize = citySize;
    }
}
