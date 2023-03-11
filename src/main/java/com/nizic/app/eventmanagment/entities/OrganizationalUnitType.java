package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "organizational_unit_type")
public class OrganizationalUnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationalUnitTypeID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "active", nullable = false)
    private Boolean active;

    public OrganizationalUnitType() {
        super();
    }

    public OrganizationalUnitType(Long organizationalUnitTypeID, String name, Boolean active) {
        this.organizationalUnitTypeID = organizationalUnitTypeID;
        this.name = name;
        this.active = active;
    }

    public Long getOrganizationalUnitTypeID() {
        return organizationalUnitTypeID;
    }

    public void setOrganizationalUnitTypeID(Long organizationalUnitTypeID) {
        this.organizationalUnitTypeID = organizationalUnitTypeID;
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
