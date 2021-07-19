package com.example.HotelManagementSystemAPIProject.repository;


import com.example.HotelManagementSystemAPIProject.Entities.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderTable, Integer> {
}
