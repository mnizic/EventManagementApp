package com.nizic.app.eventmanagment.controllers;

import com.nizic.app.eventmanagment.entities.Event;
import com.nizic.app.eventmanagment.services.CityService;
import com.nizic.app.eventmanagment.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private CityService cityService;

    @GetMapping("/events")
    public String showEventsList(Model model, @Param("keyword") String keyword,
                                 @Param("startDateTimeFrom") String startDateTimeFrom, @Param("endDateTimeFrom") String endDateTimeFrom,
                                 @Param("startDateTimeTo") String startDateTimeTo, @Param("endDateTimeTo") String endDateTimeTo,
                                 @RequestParam(name = "freeEntry", required = false) Boolean freeEntry) {
        if (startDateTimeFrom != null && endDateTimeFrom != null) {
            LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeFrom);
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeFrom);
            model.addAttribute("listOfEvents", eventService.listFromBetweenEvents(startDateTime, endDateTime));
        } else if (startDateTimeTo != null && endDateTimeTo != null) {
            LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeTo);
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeTo);
            model.addAttribute("listOfEvents", eventService.listToBetweenEvents(startDateTime, endDateTime));
        } else if (freeEntry != null) {
            model.addAttribute("listOfEvents", eventService.listFreeEntry(freeEntry));
        } else {
            model.addAttribute("listOfEvents", eventService.listAllEvents(keyword));
            //model.addAttribute("keyword", keyword);
        }
        return "events";
    }

    @GetMapping("/events/new")
    public String showNewEventForm(Model model) {
        model.addAttribute("title", "Add New Event");
        model.addAttribute("event", new Event());
        model.addAttribute("options", cityService.listAllCities());
        return "eventForm";
    }

    @PostMapping("/events/add")
    public String addEvent(Event event, RedirectAttributes redirectAttributes) {
        eventService.add(event);
        redirectAttributes.addFlashAttribute("message", "Event saved successfully!");
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{id}")
    public String showUpdateEventForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("event", eventService.get(id));
            model.addAttribute("title", "Edit Event (ID: " + id + ")");
            model.addAttribute("options", cityService.listAllCities());
            model.addAttribute("fromDateTime", eventService.get(id).getFrom());
            model.addAttribute("toDateTime", eventService.get(id).getTo());
            redirectAttributes.addFlashAttribute("message", "Event updated successfully!");
            return "eventForm";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("warning", e.getMessage());
            return "redirect:/events";
        }
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            eventService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Event with an ID: " + id + " deleted successfully!");
            return "redirect:/events";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("warning", e.getMessage());
            return "redirect:/events";
        }
    }
}
