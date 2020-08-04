package com.wcci.foodtruckfrenzy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Location implements Comparable<Location>{
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

    public String getDayOfWeekString() {
        return dayOfWeek.getDisplayName(TextStyle.FULL,
                Locale.getDefault());
    }

    public boolean isRecurring() {
        return recurring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0 &&
                recurring == location.recurring &&
                Objects.equals(address, location.address) &&
                Objects.equals(date, location.date) &&
                dayOfWeek == location.dayOfWeek &&
                Objects.equals(openHours, location.openHours) &&
                Objects.equals(vendor, location.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, latitude, longitude, date, dayOfWeek, recurring, openHours, vendor);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", date=" + date +
                ", dayOfWeek=" + dayOfWeek +
                ", recurring=" + recurring +
                ", openHours='" + openHours + '\'' +
                ", vendor=" + vendor +
                '}';
    }

    @Override
    public int compareTo(Location location) {
        return this.dayOfWeek.compareTo(location.getDayOfWeek());
    }
}
