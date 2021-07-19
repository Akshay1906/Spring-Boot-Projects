package com.example.EventRegistration.Dao;

import com.example.EventRegistration.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationDao extends JpaRepository <Registration,String> {



}
