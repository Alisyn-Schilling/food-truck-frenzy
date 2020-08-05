package com.wcci.foodtruckfrenzy.storage;

import com.wcci.foodtruckfrenzy.entities.Location;
import com.wcci.foodtruckfrenzy.storage.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class LocationStorage {
    LocationRepository locationRepo;

    public LocationStorage(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Iterable<Location> getByDayOfWeek(DayOfWeek dayOfWeek) {
        return locationRepo.findByDayOfWeek(dayOfWeek);
    }


    public void save(Location location) {
        locationRepo.save(location);
    }

}
