package com.wcci.foodtruckfrenzy.controllers;

import com.wcci.foodtruckfrenzy.storage.EventStorage;
import com.wcci.foodtruckfrenzy.storage.VendorStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    VendorStorage vendorStorage;
    private EventStorage eventStorage;

    public AdminController(VendorStorage vendorStorage, EventStorage eventStorage) {
        this.vendorStorage = vendorStorage;
        this.eventStorage = eventStorage;
    }

    @GetMapping("/new-vendor")
    public String newVendorPage(Model model){
        return "new-vendor-template";
    }

    @GetMapping("/admin/{name}")
    public String findByName(@PathVariable String name, Model model){
        model.addAttribute("vendors", vendorStorage.findByName(name));
        return "admin-profile-template";
    }

    @GetMapping("/admin/events/{name}")
    public String findAdminEventByName(@PathVariable String name, Model model){
        model.addAttribute("vendors", vendorStorage.getAllVendors());
        model.addAttribute("events", eventStorage.findByName(name));
        return "admin-event-page-template";
    }

    @GetMapping("/new-event")
    public String newEventPage(Model model){
        return "new-event-form-template";
    }

}
