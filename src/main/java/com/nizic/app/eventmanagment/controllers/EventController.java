package com.nizic.app.eventmanagment.controllers;

import com.nizic.app.eventmanagment.entities.Event;
import com.nizic.app.eventmanagment.services.CityService;
import com.nizic.app.eventmanagment.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private CityService cityService;

    @GetMapping("/events")
    public String showEventsList(Model model) {
        model.addAttribute("listOfEvents", eventService.listAllEvents());
        return "events";
    }

    @GetMapping("/events/new")
    public String showNewEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("options", cityService.listAllCities());
        return "newEventForm";
    }

    @PostMapping("/events/add")
    public String addEvent(Event event, RedirectAttributes redirectAttributes) {
        eventService.add(event);
        redirectAttributes.addFlashAttribute("message", "Event added successfully!");
        return "redirect:/events";
    }
}
