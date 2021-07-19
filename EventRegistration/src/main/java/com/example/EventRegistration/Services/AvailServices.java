package com.example.EventRegistration.Services;

import com.example.EventRegistration.Entity.Events;
import com.example.EventRegistration.Entity.Registration;
import com.example.EventRegistration.Entity.UserEvents;

import java.util.List;
import java.util.Optional;

public interface AvailServices {

    public String RegisterUser(Registration registration);
    public Optional<Registration> Login(Registration registration);
    public List<Events> getEvents();

    public String RegisterEvent(UserEvents userEvents);
    public List <UserEvents> RegisteredEvent(UserEvents userEvents);

}
