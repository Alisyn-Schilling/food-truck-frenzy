package com.wcci.foodtruckfrenzy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vendor {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String menuLink;
    private String priceRange;
    private String address;
    private String imagePath;
    private double latitude;
    private double longitude;
    @ManyToMany
    private Collection<Event> events;

    protected Vendor() {
    }

    public Vendor(String name, String menuLink, String priceRange, String address, String imagePath, double latitude, double longitude, Event... events) {

        this.name = name;
        this.menuLink = menuLink;
        this.priceRange = priceRange;
        this.address = address;
        this.imagePath = imagePath;
        this.latitude = latitude;
        this.longitude = longitude;
        this.events = new ArrayList<>(Arrays.asList(events));
    }

    public String getName() {
        return name;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getAddress() {
        return address;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return id == vendor.id &&
                Double.compare(vendor.latitude, latitude) == 0 &&
                Double.compare(vendor.longitude, longitude) == 0 &&
                Objects.equals(name, vendor.name) &&
                Objects.equals(menuLink, vendor.menuLink) &&
                Objects.equals(priceRange, vendor.priceRange) &&
                Objects.equals(address, vendor.address) &&
                Objects.equals(imagePath, vendor.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuLink, priceRange, address, imagePath, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menuLink='" + menuLink + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", address='" + address + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}
