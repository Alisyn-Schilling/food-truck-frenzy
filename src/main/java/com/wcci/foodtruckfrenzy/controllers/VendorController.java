package com.wcci.foodtruckfrenzy.controllers;

import com.wcci.foodtruckfrenzy.entities.Event;
import com.wcci.foodtruckfrenzy.storage.EventStorage;
import com.wcci.foodtruckfrenzy.entities.Vendor;
import com.wcci.foodtruckfrenzy.storage.VendorStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorController {

    VendorStorage vendorStorage;
    EventStorage eventStorage;

    public VendorController(VendorStorage vendorStorage, EventStorage eventStorage) {
        this.vendorStorage = vendorStorage;
        this.eventStorage = eventStorage;
    }

    @GetMapping("/vendors")
    public String showAllVendors(Model model){
        model.addAttribute("vendors", vendorStorage.getAllVendors());
        return "all-vendors-template";
    }
    @GetMapping("/vendors/{name}")
    public String findByName(@PathVariable String name, Model model){
        model.addAttribute("vendors", vendorStorage.findByName(name));
        return "vendor-profile-template";
    }
    @PostMapping("/vendors")
    public String addVendor(String name, String bio, String menuLink,
                            String imagePath){
        Vendor vendorToAdd = new Vendor(name, bio, menuLink, imagePath);
        vendorStorage.save(vendorToAdd);
        return "redirect:/admin/" + vendorToAdd.getName();
    }
    @PostMapping("/vendors/events")
    public String addEventToVendor(long vendorId, long eventId){
        Vendor vendor = vendorStorage.findById(vendorId);
        Event event = eventStorage.findById(eventId);
        vendor.addEvent(event);
        return "redirect:/events/" + event.getName();
    }

}
