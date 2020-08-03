package com.wcci.foodtruckfrenzy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event implements Comparable<Event> {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private LocalDate date;
    private String imagePath;
    private String address;
    private String times;
    private double latitude;
    private double longitude;
    private String locationName;
    @ManyToMany(mappedBy = "events")
    private Collection<Vendor> vendors;

    protected Event() {
    }

    public Event(String name, LocalDate date, String imagePath, String address, String times, double latitude, double longitude, String locationName) {
        this.name = name;
        this.date = date;
        this.imagePath = imagePath;
        this.address = address;
        this.times = times;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getTimes() {
        return times;
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

    public Collection<Vendor> getVendors() {
        return vendors;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Double.compare(event.latitude, latitude) == 0 &&
                Double.compare(event.longitude, longitude) == 0 &&
                Objects.equals(name, event.name) &&
                Objects.equals(date, event.date) &&
                Objects.equals(imagePath, event.imagePath) &&
                Objects.equals(address, event.address) &&
                Objects.equals(times, event.times) &&
                Objects.equals(locationName, event.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, imagePath, address, times, latitude, longitude, locationName);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", imagePath='" + imagePath + '\'' +
                ", address='" + address + '\'' +
                ", times='" + times + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", locationName='" + locationName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Event event) {
        return this.date.compareTo(event.getDate());
    }
}
