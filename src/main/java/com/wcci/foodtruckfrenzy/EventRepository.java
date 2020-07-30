package com.wcci.foodtruckfrenzy;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName(String eventName);
}
