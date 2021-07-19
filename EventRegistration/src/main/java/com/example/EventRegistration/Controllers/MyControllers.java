package com.example.EventRegistration.Controllers;

import com.example.EventRegistration.Entity.Events;
import com.example.EventRegistration.Entity.Registration;
import com.example.EventRegistration.Entity.UserEvents;
import com.example.EventRegistration.Services.AvailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyControllers {

    @Autowired
    AvailServices availServices;


    @PostMapping("/user")
    public String RegisterUser(@RequestBody Registration registration){
        return this.availServices.RegisterUser(registration);
    }

    @GetMapping("/user")
    public Optional<Registration> Login(@RequestBody Registration registration){
        return this.availServices.Login(registration);
    }
    @GetMapping("/events")
    public List<Events> getEvents(){
        return this.availServices.getEvents();
    }

    @PostMapping("/register-event")
    public String RegisterEvent(@RequestBody UserEvents userEvents){
        return this.availServices.RegisterEvent(userEvents);
    }

    @GetMapping("/show-registered-event")
    public List <UserEvents> RegisteredEvent(@RequestBody UserEvents userEvents){
        return this.availServices.RegisteredEvent(userEvents);
    }
}
