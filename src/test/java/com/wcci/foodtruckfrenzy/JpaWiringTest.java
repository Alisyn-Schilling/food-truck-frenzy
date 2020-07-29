package com.wcci.foodtruckfrenzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private VendorRepository vendorRepo;
    @Autowired
    private EventRepository eventRepo;
}
