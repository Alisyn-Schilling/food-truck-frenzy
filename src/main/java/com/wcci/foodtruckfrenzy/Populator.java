package com.wcci.foodtruckfrenzy;

import com.wcci.foodtruckfrenzy.entities.Event;
import com.wcci.foodtruckfrenzy.entities.Location;
import com.wcci.foodtruckfrenzy.entities.Vendor;
import com.wcci.foodtruckfrenzy.storage.repositories.EventRepository;
import com.wcci.foodtruckfrenzy.storage.repositories.LocationRepository;
import com.wcci.foodtruckfrenzy.storage.repositories.VendorRepository;
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
        LocalDate date1 = LocalDate.of(2020, 8, 6);
        Event event1 = new Event("Super Fun Event", LocalDate.of(2020, Month.AUGUST, 31), "../../images/HometownMarket.jpg", "3895 Columbus Rd, Centerburg, Ohio 43011", "3:00pm - 8:00pm", 40.3002819, -82.7057998, "Hometown Market");
        eventRepository.save(event1);
        Event event2 = new Event("2020 Columbus Summer Wine Festival", LocalDate.of(2020, Month.AUGUST, 22), "../../images/ColumbusSummerWineFestival.jpg", "160 S. High Street, Columbus, Ohio 43215", "12:00pm - 8:00pm", 39.9688641, -83.0562056, "John F. Wolfe Columbus Commons");
        eventRepository.save(event2);
        Event event3 = new Event("Central Ohio Afro Fest", LocalDate.of(2020, Month.OCTOBER, 18), "../../images/CentralOhioAfroFest.jpg", "2101 Noe Bixby Road, Columbus, Ohio 43232", "12:00pm - 6:00pm", 39.9628774, -93.0314769, "Phenix Banquet Center");
        eventRepository.save(event3);
        Event event4 = new Event("New Birth: Movie on the Lawn", LocalDate.of(2020, Month.AUGUST, 20), "../../images/MovieOnTheLawn.jpg", "3475 Refugee Road, Columbus, Ohio 43232", "7:00pm - 11:00pm", 39.952106, -83.0268608, "New Birth Christian Ministries");
        eventRepository.save(event4);
        Event event5 = new Event("Rockmill Brewery Summer Music Series: Charles & McKevitt", LocalDate.of(2020, Month.AUGUST, 16), "../../images/RockmillBrewery.jpg", "5705 Lithopolis Road Northwest", "5:00pm - 7:00pm", 39.8694521, -83.0347285, "Rockmill Brewery");
        eventRepository.save(event5);
        Event event6 = new Event("Reynoldsburg Festival", LocalDate.of(2020, Month.AUGUST, 8), "../../images/ReynoldsburgFestival.jpg", "1636 Graham Road, Reynoldsburg, Ohio 43068", "6:00pm - 8:00pm", 39.9713941, -83.0033249, "Reynoldsburg United Methodist Church");
        eventRepository.save(event6);
        Vendor vendor1 = new Vendor("Louisiana Grill", "Sara T's Favorite Food Truck in the Entire World yum yum yum cajun food", "http://www.louisiana-grill.com/menu_festival.html", "../../images/LouisianaGrill.png", event1);
        vendorRepository.save(vendor1);
        Location location1 = new Location("209 E Leffel Ln, Springfield, Ohio 45505", 39.8938155, -83.8087237, date1, true, "11:00am - 5:30pm", vendor1);
        locationRepository.save(location1);
        Vendor vendor2 = new Vendor("Broke Johnny Food Truck", "Breakfast and Brunch", "http://www.brokejohnnytruck.com/#menu-1-section", "../../images/BrokeJohnny.png");
        vendorRepository.save(vendor2);
        Location location2 = new Location("2245 N Bank Dr, Columbus, Ohio 43220", 40.0561122, -83.0807217, date1, true, "11:00am - 1:00pm", vendor2);
        locationRepository.save(location2);
        Vendor vendor3 = new Vendor("Exotic Latino Grill", "Nuevo Latino", " https://www.zmenu.com/exotic-latino-grill-columbus-2-online-menu/", "../../images/exotic-latino-grill.png");
        vendorRepository.save(vendor3);
        Location location3 = new Location("355 E Hudson St, Columbus, OH 43202", 40.0147968, -83.0014099, date1, true, "10:00am - 1:00am", vendor3);
        locationRepository.save(location3);
        Vendor vendor4 = new Vendor("Cousin's Maine Lobster", "Seafood", "https://www.cousinsmainelobster.com/menu/?location=columbus_oh&type=truck/", "../../images/cousin-logo.png");
        vendorRepository.save(vendor4);
        Location location4 = new Location("2330 Alum Crossing Dr, Lewis Center, Ohio 43035", 40.18541669, -82.9925099, date1, true, "4:30pm - 7:30pm", vendor4);
        locationRepository.save(location4);
        Vendor vendor5 = new Vendor("Ray Ray's Hog Pit", "BBQ", "https://www.rayrayshogpit.com/", "../../images/ray-rays.png");
        vendorRepository.save(vendor5);
        Location location5 = new Location(" 2619 North High St, Columbus, Ohio 43202", 40.0156861, -83.0118406, date1, true, "11:30am - 8:00pm", vendor5);
        locationRepository.save(location5);
        Vendor vendor6 = new Vendor("Schmidt's", "German", "https://www.schmidthaus.com/sausage-truck-menu/", "../../images/schmidts.png");
        vendorRepository.save(vendor6);
        Location location6 = new Location("4541 N High St, Clintonville, Ohio 43214", 40.054623, -83.020493, date1, true, "4:00pm - 8:00pm", vendor6);
        locationRepository.save(location6);
        Vendor vendor7 = new Vendor("Dos Hermanos", "Mexican", "https://doshermanoscolumbus.com/menu/", "../../images/dos.png");
        vendorRepository.save(vendor7);
        Location location7 = new Location("5451 Edwards Farms Rd, Columbus, Ohio 43221", 40.0631890, -83.1285855, date1, true, "4:30pm - 7:30pm", vendor7);
        locationRepository.save(location7);
        Vendor vendor8 = new Vendor("Kabob Time", "Mediterranean", "http://places.singleplatform.com/kabob-time/menu?ref=google", "../../images/kabob.png");
        vendorRepository.save(vendor8);
        Location location8 = new Location("2570 N High St, Columbus, OH 43202", 40.0147579, -83.0110012, date1, true, "12:00am - 12:00pm", vendor8);
        locationRepository.save(location8);
        Vendor vendor9 = new Vendor("The Angry Weiner", "Hot Dogs", "https://www.theangrywiener.com/menu", "../../images/wiener.png");
        vendorRepository.save(vendor9);
        Location location9 = new Location("430 N Hamilton Rd, Whitehall, Ohio 43213", 39.9847516, -82.8689632, date1, true, "11:30am - 1:30pm", vendor9);
        locationRepository.save(location9);
    }
}
