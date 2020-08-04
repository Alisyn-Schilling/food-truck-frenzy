package com.wcci.foodtruckfrenzy.controllers;

import com.wcci.foodtruckfrenzy.storage.VendorStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NewVendorController {
    VendorStorage vendorStorage;

    public NewVendorController(VendorStorage vendorStorage) {
        this.vendorStorage = vendorStorage;
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

}
