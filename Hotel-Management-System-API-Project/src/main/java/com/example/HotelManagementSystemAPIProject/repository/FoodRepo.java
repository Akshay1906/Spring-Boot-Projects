package com.example.HotelManagementSystemAPIProject.repository;


import com.example.HotelManagementSystemAPIProject.Entities.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository <FoodMenu,Integer> {
}
