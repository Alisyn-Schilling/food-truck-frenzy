package com.wcci.foodtruckfrenzy;

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
    public String addVendor(String name, String menuLink, String address,
                            String imagePath){
        Vendor vendorToAdd = new Vendor(name, menuLink, address, imagePath);
        vendorStorage.save(vendorToAdd);
        return "redirect:/vendors/" + vendorToAdd.getName();
    }
    @PostMapping("/vendors/events")
    public String addEventToVendor(long id, String eventName){
        Vendor vendor = vendorStorage.findById(id);
        Event event = eventStorage.findByName(eventName);
        vendor.addEvent(event);
        return "redirect:/vendors/" + vendor.getName();
    }

}
