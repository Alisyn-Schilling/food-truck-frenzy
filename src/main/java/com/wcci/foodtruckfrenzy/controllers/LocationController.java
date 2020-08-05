package com.wcci.foodtruckfrenzy.controllers;

import com.wcci.foodtruckfrenzy.entities.Location;
import com.wcci.foodtruckfrenzy.entities.Vendor;
import com.wcci.foodtruckfrenzy.storage.LocationStorage;
import com.wcci.foodtruckfrenzy.storage.VendorStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller

public class LocationController {
    LocationStorage locationStorage;
    VendorStorage vendorStorage;

    public LocationController(LocationStorage locationStorage, VendorStorage vendorStorage) {
        this.locationStorage = locationStorage;
        this.vendorStorage = vendorStorage;
    }

    @GetMapping("/locations")
    public String showTodaysLocations(Model model) {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        model.addAttribute("locations", locationStorage.getByDayOfWeek(dayOfWeek));

        return "map-template";
    }
    @PostMapping("/locations")
    public String addLocationToVendor(long vendorId, String address, double latitude,
                                      double longitude, String date, boolean recurring, String openHours){
        LocalDate localDate = LocalDate.parse(date);
        Vendor vendor = vendorStorage.findById(vendorId);
        Location location = new Location(address, latitude, longitude, localDate, recurring, openHours, vendor);
        locationStorage.save(location);
        return "redirect:/admin/" + vendor.getName();

    }

}


