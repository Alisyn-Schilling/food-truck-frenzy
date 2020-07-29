package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Service;

@Service
public class EventStorage {
    EventRepository eventRepo;

    public Event findByName(String eventName) {
        return eventRepo.findByName(eventName);
    }
}
