package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

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
        model.addAttribute("events", eventStorage.getAllEvents());
        return "all-events-template";
    }
    @GetMapping("/events/{name}")
    public String findByName(@PathVariable String name, Model model){
        model.addAttribute("events", eventStorage.findByName(name));
        return "event-page-template";
    }
    @PostMapping("/events")
    public String addEvent(String name, Date date, String address, String times, double latitude,
                           double longitude){
        Event eventToAdd = new Event(name, date, address, times, latitude, longitude);
        eventStorage.save(eventToAdd);
        return "redirect:/events/" + eventToAdd.getName();
    }

}
