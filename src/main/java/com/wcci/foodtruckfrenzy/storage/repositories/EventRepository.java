package com.wcci.foodtruckfrenzy.storage.repositories;

import com.wcci.foodtruckfrenzy.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName(String eventName);
}
