package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "organizational_unit")
public class OrganizationalUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationalUnitID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regionid", referencedColumnName = "organizationalunitid", nullable = true)
    private OrganizationalUnit region;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizationalunittypeid", referencedColumnName = "organizationalunittypeid", nullable = false)
    private OrganizationalUnitType organizationalUnitType;

    public OrganizationalUnit() {
        super();
    }

    public OrganizationalUnit(Long organizationalUnitID,
                              String name, String description,
                              OrganizationalUnit region,
                              OrganizationalUnitType organizationalUnitType) {
        this.organizationalUnitID = organizationalUnitID;
        this.name = name;
        this.description = description;
        this.region = region;
        this.organizationalUnitType = organizationalUnitType;
    }

    public Long getOrganizationalUnitID() {
        return organizationalUnitID;
    }

    public void setOrganizationalUnitID(Long organizationalUnitID) {
        this.organizationalUnitID = organizationalUnitID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrganizationalUnit getRegion() {
        return region;
    }

    public void setRegion(OrganizationalUnit regionID) {
        this.region = region;
    }

    public OrganizationalUnitType getOrganizationalUnitType() {
        return organizationalUnitType;
    }

    public void setOrganizationalUnitType(OrganizationalUnitType organizationalUnitType) {
        this.organizationalUnitType = organizationalUnitType;
    }
}
