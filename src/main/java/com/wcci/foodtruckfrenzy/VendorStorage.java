package com.wcci.foodtruckfrenzy;

import org.springframework.stereotype.Service;

@Service
public class VendorStorage {
    VendorRepository vendorRepo;

    public VendorStorage(VendorRepository vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    public Vendor findById(long id) {
        return vendorRepo.findById(id).get();
    }

    public void save(Vendor vendor) {
        vendorRepo.save(vendor);
    }

    public Iterable<Vendor>getAllVendors() {
        return vendorRepo.findAll();
    }

    public Vendor findByName(String name) {
        return vendorRepo.findByName(name);
    }
}
