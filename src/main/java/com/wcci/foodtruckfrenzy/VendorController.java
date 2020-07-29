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
        return "";
    }
    @GetMapping("/vendors/{name}")
    public String findByName(@PathVariable String name, Model model){
        model.addAttribute("vendors", vendorStorage.findByName(name));
        return "";
    }
    @PostMapping("/vendors/")
    public String addVendor(String name, String menuLink, String priceRange, String address,
                            String imagePath, double latitude, double longitude){
        Vendor vendorToAdd = new Vendor(name, menuLink, priceRange, address, imagePath, latitude, longitude);
        VendorStorage.save(vendorToAdd);
        return "redirect:/vendors" + vendorToAdd.getName();
    }
    @PostMapping("/vendors/events")
    public String addEventToVendor(long id, String eventName){
        Vendor vendor = VendorStorage.findById(id);
        Event event = EventStorage.
        return
    }

}
