package com.wcci.foodtruckfrenzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    LocationRepository locationRepository;

    @Override
    public void run(String...args) throws Exception {
        LocalDate date1 = LocalDate.of(2020, Month.AUGUST, 1);
        Event event1 = new Event("Super Fun Event", date1, "../../images/HometownMarket.jpg", "3895 Columbus Rd", "3:00-8:00", 40.3002819, -82.7057998, "Hometown Market");
        eventRepository.save(event1);
    }
}
