package com.example.EventRegistration.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int eventid;
    private String email;

    public UserEvents(){}

    public UserEvents(int eventid, String email) {
        this.eventid = eventid;
        this.email = email;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
