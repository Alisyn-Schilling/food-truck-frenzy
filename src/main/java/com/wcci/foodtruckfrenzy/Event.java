package com.wcci.foodtruckfrenzy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Date date;
    private String imagePath;
    private String address;
    private String times;
    private double latitude;
    private double longitude;
    @ManyToMany(mappedBy = "events")
    private Collection<Vendor> vendors;

    protected Event() {
    }

    public Event(String name, Date date, String imagePath, String address, String times, double latitude, double longitude) {
        this.name = name;
        this.date = date;
        this.imagePath = imagePath;
        this.address = address;
        this.times = times;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Double.compare(event.latitude, latitude) == 0 &&
                Double.compare(event.longitude, longitude) == 0 &&
                Objects.equals(name, event.name) &&
                Objects.equals(address, event.address) &&
                Objects.equals(times, event.times);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, address, times, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", times='" + times + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
