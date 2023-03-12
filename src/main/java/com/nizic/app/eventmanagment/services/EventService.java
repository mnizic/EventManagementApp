package com.nizic.app.eventmanagment.services;

import com.nizic.app.eventmanagment.entities.Event;
import com.nizic.app.eventmanagment.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired private EventRepository repo;
    public List<Event> listAllEvents(){
        return (List<Event>) repo.findAll();
    }


    public void add(Event event) {
        LocalDateTime from = event.getFrom();
        LocalDateTime to = event.getTo();
        event.setFrom(from);
        event.setTo(to);
        repo.save(event);
    }
}
