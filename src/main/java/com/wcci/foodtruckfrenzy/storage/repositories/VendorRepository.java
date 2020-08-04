package com.wcci.foodtruckfrenzy.storage.repositories;

import com.wcci.foodtruckfrenzy.entities.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
     Vendor findByName(String name);
}
