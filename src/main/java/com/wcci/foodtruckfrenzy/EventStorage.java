package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class EventStorage {
    EventRepository eventRepo;

    public EventStorage(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

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
        LocalDate date = LocalDate.now();
        ArrayList<Event> nextEvent = new ArrayList<>();
        for (Event event : eventRepo.findAll()) {
            if (event.getDate().isAfter(date.minusDays(1))) {
                nextEvent.add(event);
            }
        }
        if (nextEvent.isEmpty()) {
            LocalDate futureDate = LocalDate.of(2022, Month.AUGUST, 31);
            Event futureEvent = new Event("Come back later for this event", futureDate, "N/A", "N/A", "N/A", 0.00, 0.00, "Ohio");
            return futureEvent;
        }
        Collections.sort(nextEvent);
        return nextEvent.get(0);
    }
}
