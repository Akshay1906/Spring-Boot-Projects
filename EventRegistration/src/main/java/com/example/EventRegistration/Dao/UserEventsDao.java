package com.example.EventRegistration.Dao;

import com.example.EventRegistration.Entity.UserEvents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEventsDao extends JpaRepository<UserEvents,Integer> {
    List<UserEvents> findAllById(String email);
}
