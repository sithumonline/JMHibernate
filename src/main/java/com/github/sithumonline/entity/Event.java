package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Event {
    private int id;
    private String name;
    private String venue;
    private String date;
    private String organizer;
    private int numberOfSponsorships;

    public Event(int id, String name, String venue, String date, String organizer, int numberOfSponsorships) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.organizer = organizer;
        this.numberOfSponsorships = numberOfSponsorships;
    }

    public Event(String id, String name, String venue, String date, String organizer, int numberOfSponsorships) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.organizer = organizer;
        this.numberOfSponsorships = numberOfSponsorships;
    }

    public Event(String name, String venue, String date, String organizer, int numberOfSponsorships) {
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.organizer = organizer;
        this.numberOfSponsorships = numberOfSponsorships;
    }

    public Event() {

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "venue")
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "organizer")
    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    @Basic
    @Column(name = "numberOfSponsorships")
    public int getNumberOfSponsorships() {
        return numberOfSponsorships;
    }

    public void setNumberOfSponsorships(int numberOfSponsorships) {
        this.numberOfSponsorships = numberOfSponsorships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return numberOfSponsorships == event.numberOfSponsorships && Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(date, event.date) && Objects.equals(organizer, event.organizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, organizer, numberOfSponsorships);
    }
}
