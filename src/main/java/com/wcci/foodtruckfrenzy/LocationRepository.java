package com.wcci.foodtruckfrenzy;

import org.springframework.data.repository.CrudRepository;

import java.time.DayOfWeek;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Iterable<Location> findByDayOfWeek(DayOfWeek dayToFind);
}
