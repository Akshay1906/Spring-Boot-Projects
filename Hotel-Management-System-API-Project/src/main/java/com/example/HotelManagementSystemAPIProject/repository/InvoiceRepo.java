package com.example.HotelManagementSystemAPIProject.repository;

import com.example.HotelManagementSystemAPIProject.Entities.InvoiceTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository <InvoiceTable,Integer> {
}
