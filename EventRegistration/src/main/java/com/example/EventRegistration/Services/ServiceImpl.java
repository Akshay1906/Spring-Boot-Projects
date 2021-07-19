package com.example.EventRegistration.Services;

import com.example.EventRegistration.Dao.EventsDao;
import com.example.EventRegistration.Dao.RegistrationDao;
import com.example.EventRegistration.Dao.UserEventsDao;
import com.example.EventRegistration.Entity.Events;
import com.example.EventRegistration.Entity.Registration;
import com.example.EventRegistration.Entity.UserEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements AvailServices{


    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    EventsDao eventsDao;
    @Autowired
    UserEventsDao userEventsDao;

    //Register User
    @Override
    public String RegisterUser(Registration registration) {
        Optional <Registration> reg= registrationDao.findById(registration.getEmail());
        if(reg.isPresent()){
            return "User Already Exist !!!!!";
        }
        else{
            registrationDao.save(registration);
            return "Registered Successfuly.......";
        }
    }
   // Login Service
    @Override
    public Optional<Registration> Login(Registration registration) {
        Optional<Registration> obj = null;
        Optional <Registration> reg = registrationDao.findById(registration.getEmail());

        if(reg.isPresent()){
            obj = registrationDao.findById(registration.getEmail());
            return obj;
        }
        return obj;
    }

    //List all events
    @Override
    public List<Events> getEvents() {
        return eventsDao.findAll();
    }

    // Register user for the event
    @Override
    public String RegisterEvent(UserEvents userEvents) {
        Optional<Registration> obj = null;
        Optional <Registration> reg= registrationDao.findById(userEvents.getEmail());
        if(reg.isPresent()){
            userEventsDao.save(userEvents);
            return "Registered Successfully";
        }
        else{
            return "Invalid User";
        }

    }

    // Show registered event for the user
    @Override
    public List <UserEvents> RegisteredEvent(UserEvents userEvents) {

        List <UserEvents>  list;
        List <UserEvents > out = new ArrayList<>();
        list = userEventsDao.findAll();
        for(UserEvents i : list){
            if(i.getEmail().equals(userEvents.getEmail()) ){
                out.add(i);
            }
        }
        return out;
    }

}
