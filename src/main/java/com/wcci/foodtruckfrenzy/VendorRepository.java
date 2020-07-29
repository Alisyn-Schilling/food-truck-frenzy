package com.wcci.foodtruckfrenzy;

import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
     Vendor findByName(String name);
}
