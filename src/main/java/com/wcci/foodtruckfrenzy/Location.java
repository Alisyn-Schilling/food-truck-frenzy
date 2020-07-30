package com.wcci.foodtruckfrenzy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalDate;
@Entity
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String address;
    private double latitude;
    private double longitude;
    private LocalDate date;
    private DayOfWeek dayOfWeek;
    private boolean recurring;
    private String openHours;
    @ManyToOne
    private Vendor vendor;

    protected Location() {
    }

    public Location(String address, double latitude, double longitude, LocalDate date, boolean recurring, String openHours, Vendor vendor) {

        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.dayOfWeek = date.getDayOfWeek();
        this.recurring = recurring;
        this.openHours = openHours;
        this.vendor = vendor;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getOpenHours() {
        return openHours;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public long getId() {
        return id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isRecurring() {
        return recurring;
    }
}
