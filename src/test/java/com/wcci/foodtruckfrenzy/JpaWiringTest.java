package com.wcci.foodtruckfrenzy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private VendorRepository vendorRepo;
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void EventsCanHaveMultipleVendors() {
        Date date = new Date();
        Event testEvent1 = new Event("testEvent1", date, "address1", "times1", 45.23423, 64.1234);
        Event testEvent2 = new Event("testEvent2", date, "address2", "times2", 83.23423, 25.1234);
        eventRepo.save(testEvent1);
        eventRepo.save(testEvent2);
        Vendor testVendor = new Vendor("name", "menuLink", "priceRange", "address",
                "imagePath", 45.23425, 64.242351, testEvent1, testEvent2);
        vendorRepo.save(testVendor);
        Vendor testVendor2 = new Vendor("testVendor2", "menuLink", "priceRange", "address",
                "imagePath", 474.23425, 23.242351, testEvent1);
        vendorRepo.save(testVendor2);

        entityManager.flush();
        entityManager.clear();

        Event retrievedEvent = eventRepo.findById(testEvent1.getId()).get();
        assertThat(retrievedEvent).isEqualTo(testEvent1);
        assertThat(retrievedEvent.getVendors()).containsExactlyInAnyOrder(testVendor, testVendor2);
    }

    @Test
    public void vendorsCanHaveMultipleLocations() {
        LocalDate testDate = LocalDate.of(2020, Month.JULY, 30);
        Vendor testVendor = new Vendor("name", "menuLink", "priceRange", "address",
                "imagePath", 45.23425, 64.242351);
        vendorRepo.save(testVendor);
        Location testLocation = new Location("address", 45.23423, 23.4234,
                testDate, true, "openHours", testVendor);
        locationRepo.save(testLocation);
        LocalDate testDate2 = LocalDate.of(2020, Month.JULY, 31);
        Location testLocation2 = new Location("address2", 53.23423, 53.4234,
                testDate2, true, "openHours", testVendor);
        locationRepo.save(testLocation2);

        entityManager.flush();
        entityManager.clear();

        Vendor retrievedVendor = vendorRepo.findById(testVendor.getId()).get();
        assertThat(retrievedVendor).isEqualTo(testVendor);


    }
}
