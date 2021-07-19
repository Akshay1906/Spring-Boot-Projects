package com.example.HotelManagementSystemAPIProject.repository;


import com.example.HotelManagementSystemAPIProject.Entities.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookinRepo extends JpaRepository <RoomBooking,Long> {
}
