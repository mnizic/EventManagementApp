package com.nizic.app.eventmanagment.entities;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "from", nullable = false)
    private SimpleDateFormat from;
    @Column(name = "to", nullable = false)
    private SimpleDateFormat to;

    public Event() {
        super();
    }

    public Event(String name, SimpleDateFormat from, SimpleDateFormat to) {
        super();
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleDateFormat getFrom() {
        return from;
    }

    public void setFrom(SimpleDateFormat from) {
        this.from = from;
    }

    public SimpleDateFormat getTo() {
        return to;
    }

    public void setTo(SimpleDateFormat to) {
        this.to = to;
    }
}
