package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    EventStorage eventStorage;

    public HomeController(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @GetMapping({"/", ""})
    public String showUpcomingEvents(Model model) {
        model.addAttribute("event", eventStorage.findNextEvent());
        return "home-template";
    }
}
