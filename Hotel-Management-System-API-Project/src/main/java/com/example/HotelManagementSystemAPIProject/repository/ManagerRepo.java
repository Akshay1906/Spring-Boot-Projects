package com.example.HotelManagementSystemAPIProject.repository;

import com.example.HotelManagementSystemAPIProject.Entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository <Manager, Integer> {
}
