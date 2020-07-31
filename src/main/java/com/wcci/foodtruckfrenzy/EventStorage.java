package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class EventStorage {
    EventRepository eventRepo;

    public Event findByName(String eventName) {
        return eventRepo.findByName(eventName);
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public void save(Event event) {
        eventRepo.save(event);
    }

    public Event findNextEvent() {
//        Iterable<Event> allEvents = eventRepo.findAll();
        LocalDate date = LocalDate.now();
        ArrayList<Event> nextEvent = new ArrayList<>();
        for (Event event : eventRepo.findAll()) {
            if (event.getDate().isAfter(date.minusDays(1))) {
                nextEvent.add(event);
            }
        }
        if (nextEvent.isEmpty()) {
            return null;
        }
        Collections.sort(nextEvent);
        return nextEvent.get(0);
    }
}
