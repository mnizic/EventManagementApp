package com.nizic.app.eventmanagment.services;

import com.nizic.app.eventmanagment.entities.Event;
import com.nizic.app.eventmanagment.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public List<Event> listAllEvents(String keyword) {
        if (keyword != null) return (List<Event>) repo.findAll(keyword);
        return (List<Event>) repo.findAll();
    }

    public List<Event> listFromBetweenEvents(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (List<Event>) repo.findByFromBetween(startDateTime, endDateTime);
    }

    public List<Event> listToBetweenEvents(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (List<Event>) repo.findByToBetween(startDateTime, endDateTime);
    }

    public List<Event> listFreeEntry(Boolean freeEntry) {
        return (List<Event>) repo.findByFreeEntry(freeEntry);
    }

    public void add(Event event) {
        LocalDateTime from = event.getFrom();
        LocalDateTime to = event.getTo();
        event.setFrom(from);
        event.setTo(to);
        repo.save(event);
    }

    public Event get(Long id) throws Exception {
        Optional<Event> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new Exception("Event with the ID: " + id + " is not found!");
    }

    public void delete(Long id) throws Exception {
        Long count = repo.countById(id);
        if (count != null || count > 0) {
            repo.deleteById(id);
        } else {
            throw new Exception("There are no events to delete!");
        }
    }
}
