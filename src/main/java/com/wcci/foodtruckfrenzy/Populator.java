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
    public void run(String... args) throws Exception {
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
        Vendor vendor4 = new Vendor("Cousin's Maine Lobster", "Seafood", "https://www.cousinsmainelobster.com/menu/?location=columbus_oh&type=truck/", "../../images/cousin-logo.png");
        vendorRepository.save(vendor4);
        Location location4 = new Location("2330 Alum Crossing Dr, Lewis Center, Ohio 43035", 40.18541669, -82.9925099, date1, true, "4:30pm - 7:30pm", vendor4);
        locationRepository.save(location4);
        Vendor vendor5 = new Vendor("Ray Ray's Hog Pit", "BBQ", "https://www.rayrayshogpit.com/", "../../images/ray-rays.png");
        vendorRepository.save(vendor5);
        Location location5 = new Location(" 2619 North High st, Columbus, Ohio 43202", 40.0156861, -83.0118406, date1, true, "11:30am - 8:00pm", vendor5);
        locationRepository.save(location5);
        Vendor vendor6 = new Vendor("Schmidt's", "German","https://www.schmidthaus.com/sausage-truck-menu/", "../../images/schmidts.png");
        vendorRepository.save(vendor6);
        Location location6 = new Location("4541 N High St, Clintonville, Ohio 43214", 40.054623, -83.020493, date1, true, "4pm - 8pm", vendor6);
        locationRepository.save(location6);
        Vendor vendor7 = new Vendor("Dos Hermanos", "Mexican",  "https://doshermanoscolumbus.com/menu/","../../images/dos.png");
        vendorRepository.save(vendor7);
        Location location7 = new Location("5451 Edwards Farms Rd, Columbus, Ohio 43221", 40.0631890, -83.1285855, date1, true, "4:30pm - 7:30pm", vendor7);
        locationRepository.save(location7);
       Vendor vendor8 = new Vendor("Kabob Time", "Mediterranean", "http://places.singleplatform.com/kabob-time/menu?ref=google","../../images/kabob.png");
       vendorRepository.save(vendor8);
       Location location8 = new Location("2570 N High St, Columbus, OH 43202", 40.0147579, -83.0110012, date1, true, "12am - 12pm", vendor8);
       locationRepository.save(location8);
       Vendor vendor9 = new Vendor("The Angry Weiner","Hot Dogs", "https://www.theangrywiener.com/menu", "../../images/angry.png");
       vendorRepository.save(vendor9);
       Location location9 = new Location("430 N Hamilton Rd, Whitehall, Ohio 43213", 39.9847516, -82.8689632, date1, true, "11:30am - 1:30pm", vendor9);
       locationRepository.save(location9);

    }
}
