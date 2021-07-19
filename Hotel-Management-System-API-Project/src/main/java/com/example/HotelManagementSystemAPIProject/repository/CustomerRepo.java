package com.example.HotelManagementSystemAPIProject.repository;

import com.example.HotelManagementSystemAPIProject.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository <Customer,Long> {
    Boolean existsByEmail(String email);
    Customer findByEmail(String email);

}
