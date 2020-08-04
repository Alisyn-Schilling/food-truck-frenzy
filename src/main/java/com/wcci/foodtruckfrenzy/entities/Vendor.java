package com.wcci.foodtruckfrenzy.entities;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Vendor {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String bio;
    private String menuLink;
    private String imagePath;
    @ManyToMany
    private Collection<Event> events;
    @OneToMany(mappedBy = "vendor")
    private Collection<Location> locations;

    protected Vendor() {
    }

    public Vendor(String name, String bio, String menuLink, String imagePath, Event... events) {

        this.name = name;
        this.bio = bio;
        this.menuLink = menuLink;
        this.imagePath = imagePath;
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
                Objects.equals(name, vendor.name) &&
                Objects.equals(menuLink, vendor.menuLink) &&
                Objects.equals(imagePath, vendor.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuLink, imagePath);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menuLink='" + menuLink + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Collection<Location> getNext7DayLocations() {
        LocalDate date = LocalDate.now();
        ArrayList<Location> next7Days = new ArrayList<>();
        for (Location location : locations) {
            if (location.isRecurring() &&
                    location.getDate().isBefore(date)) {
                next7Days.add(location);
            } else if (location.getDate().isAfter(date.minusDays(1)) &&
                    location.getDate().isBefore(date.plusDays(8))) {
                next7Days.add(location);
            }
        }
        Collections.sort(next7Days);
        return next7Days;
    }


    public Event getNextEvent() {
        LocalDate date = LocalDate.now();
        ArrayList<Event> sortedEvents = new ArrayList<>(events);
        Collections.sort(sortedEvents);
        for (Event event : sortedEvents) {
            if (event.getDate().isAfter(date.minusDays(1))) {
                return event;
            }
        }

        Event event = new Event("No Upcoming Events", date, "n/a", "n/a", "n/a", 39.9612, -82.9988, "n/a");
        return event;
    }

    public Location getNextLocation() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Collection<Location> locations = this.getNext7DayLocations();
        for (Location location : locations) {
            if (location.getDayOfWeek().compareTo(dayOfWeek) >= 0) {
                return location;
            }
        }

        Location location = new Location("Come back later for this event", 39.9612, -82.9988, date, false, "n/a", this);
        return location;
    }


}
