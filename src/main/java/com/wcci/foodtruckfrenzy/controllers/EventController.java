package com.wcci.foodtruckfrenzy.controllers;

import com.wcci.foodtruckfrenzy.entities.Event;
import com.wcci.foodtruckfrenzy.storage.EventStorage;
import com.wcci.foodtruckfrenzy.storage.VendorStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class EventController {
    VendorStorage vendorStorage;
    EventStorage eventStorage;

    public EventController(VendorStorage vendorStorage, EventStorage eventStorage) {
        this.vendorStorage = vendorStorage;
        this.eventStorage = eventStorage;
    }

    @GetMapping("/events")
    public String showAllEvents(Model model){
        ArrayList<Event> sortedEvents = new ArrayList<>(eventStorage.getAllEvents());
        Collections.sort(sortedEvents);
        model.addAttribute("events", sortedEvents);
        return "all-events-template";
    }
    @GetMapping("/events/{name}")
    public String findByName(@PathVariable String name, Model model){
        model.addAttribute("events", eventStorage.findByName(name));
        return "event-page-template";
    }
    @PostMapping("/events")
    public String addEvent(String name, LocalDate date, String imagePath, String address, String times, double latitude,
                           double longitude, String locationName){
        Event eventToAdd = new Event(name, date, imagePath, address, times, latitude, longitude, locationName);
        eventStorage.save(eventToAdd);
        return "redirect:/events/" + eventToAdd.getName();
    }

}
