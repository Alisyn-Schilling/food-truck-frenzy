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
        Event event1 = new Event("Super Fun Event", date1, "../../images/HometownMarket.jpg", "3895 Columbus Rd", "3:00PM - 8:00PM", 40.3002819, -82.7057998, "Hometown Market");
        eventRepository.save(event1);
        Vendor vendor1 = new Vendor("Louisiana Grill", "Sara T's Favorite Food Truck in the Entire World yum yum yum cajun food", "http://www.louisiana-grill.com/menu_festival.html", "../../images/LouisianaGrill.png");
        vendorRepository.save(vendor1);
        Location location1 = new Location("209 E Leffel Ln, Springfield, Ohio 45505", 39.8938155, -83.8087237, date1, true, "11:00AM - 5:30PM", vendor1);
        locationRepository.save(location1);
        Vendor vendor2 = new Vendor("Broke Johnny Food Truck", "Breakfast and Brunch", "http://www.brokejohnnytruck.com/#menu-1-section", "../../images/BrokeJohnny.png");
        vendorRepository.save(vendor2);
        Location location2 = new Location("2245 N Bank Dr, Columbus, Ohio 43220", 40.0561122, -83.0807217, date1, true, "11:00AM - 1:00PM", vendor2);
        locationRepository.save(location2);
        Vendor vendor3 = new Vendor("Exotic Latino Grill", "Nuevo Latino", " https://www.zmenu.com/exotic-latino-grill-columbus-2-online-menu/", "../../images/exotic-latino-grill.png");
        vendorRepository.save(vendor3);
        Location location3 = new Location("355 E Hudson St, Columbus, OH 43202", 40.0147968, -83.0014099, date1, true, "10:00AM - 1:00AM", vendor3);
        locationRepository.save(location3);
        Vendor vendor4 =
    }
}
