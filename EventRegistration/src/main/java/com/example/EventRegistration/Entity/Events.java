package com.example.EventRegistration.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Events {

    @Id
    private int id;
    private String eventName;
    private String location;

    public Events(){}

    public Events(int id, String eventName, String location) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
