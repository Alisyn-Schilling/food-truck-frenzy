package com.wcci.foodtruckfrenzy;

import javax.persistence.*;
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
    private String bio;
    private String menuLink;
    private String imagePath;
    private double latitude;
    private double longitude;
    @ManyToMany
    private Collection<Event> events;
    @OneToMany(mappedBy = "vendor")
    private Collection<Location> locations;

    protected Vendor() {
    }

    public Vendor(String name, String bio, String menuLink, String imagePath, double latitude, double longitude, Event... events) {

        this.name = name;
        this.bio = bio;
        this.menuLink = menuLink;
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

    public String getImagePath() {
        return imagePath;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getId() {
        return id;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public String getBio() {
        return bio;
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
                Objects.equals(imagePath, vendor.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuLink, imagePath, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menuLink='" + menuLink + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}
