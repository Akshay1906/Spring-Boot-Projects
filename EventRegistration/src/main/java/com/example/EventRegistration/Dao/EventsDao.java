package com.example.EventRegistration.Dao;

import com.example.EventRegistration.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsDao extends JpaRepository <Events, Integer> {

}
