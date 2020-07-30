package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller

public class LocationController {
    LocationStorage locationStorage;

    public LocationController(LocationStorage locationStorage) {
        this.locationStorage = locationStorage;
    }

    @GetMapping("/locations")
    public String showTodaysLocations(Model model) {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        model.addAttribute("locations", locationStorage.getByDayOfWeek(dayOfWeek));

        return null;
    }

}


