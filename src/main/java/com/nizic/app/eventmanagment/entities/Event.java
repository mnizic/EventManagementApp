package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "from_datetime", nullable = false)
    private LocalDateTime from;
    @Column(name = "to_datetime", nullable = false)
    private LocalDateTime to;
    @Column(name = "free_entry", nullable = false)
    private Boolean freeEntry;
    @ManyToOne
    @JoinColumn(name = "cityid", referencedColumnName = "cityid", nullable = false)
    private City city;


    public Event() {
        super();
    }

    public Event(String name,
                 LocalDateTime from,
                 LocalDateTime to,
                 Boolean freeEntry,
                 City city) {
        super();
        this.name = name;
        this.from = from;
        this.to = to;
        this.freeEntry = freeEntry;
        this.city = city;
    }

    public Long getId() {
        return eventID;
    }

    public void setId(Long eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public void setFreeEntry(Boolean freeEntry) {
        this.freeEntry = freeEntry;
    }

    public Boolean getFreeEntry() {
        return freeEntry;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
