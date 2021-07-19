package com.example.HotelManagementSystemAPIProject.repository;


import com.example.HotelManagementSystemAPIProject.Entities.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository <RoomAvailability,Integer> {
}
