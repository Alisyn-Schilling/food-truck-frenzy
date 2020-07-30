package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class LocationStorage {
    LocationRepository locationRepo;

    public LocationStorage(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Iterable<Location> getByDayOfWeek(String dayOfWeek){
        DayOfWeek dayToFind = DayOfWeek.valueOf(dayOfWeek);
        return locationRepo.findByDayOfWeek(dayToFind);
    }


    public void save(Location location) {
        locationRepo.save(location);
    }

}
