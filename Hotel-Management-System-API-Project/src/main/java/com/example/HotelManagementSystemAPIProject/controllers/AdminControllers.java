package com.example.HotelManagementSystemAPIProject.controllers;

import com.example.HotelManagementSystemAPIProject.Entities.*;
import com.example.HotelManagementSystemAPIProject.repository.CustomerRepo;
import com.example.HotelManagementSystemAPIProject.repository.InvoiceRepo;
import com.example.HotelManagementSystemAPIProject.repository.OrderRepo;
import com.example.HotelManagementSystemAPIProject.repository.RoomRepo;
import com.example.HotelManagementSystemAPIProject.services.AdminAvailableServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminControllers {

    @Autowired
    AdminAvailableServices adminAvailableServices;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RoomRepo roomRepo;

    // Owner can perform these operations
    @GetMapping("/owner")
    public List<Owner> GetOwner(){
        List <Owner> list = adminAvailableServices.GetOwner();
        return list;
    }
    @GetMapping("/manager")
    public List <Manager> GetManager(){
        List <Manager> list = adminAvailableServices.GetManager();
        return list;
    }

    //only owner can Add or Delete manager
    @PostMapping("/manager/{ownerId}")
    public String AddManager(@PathVariable int ownerId, @RequestBody Manager manager){
        return this.adminAvailableServices.AddManager(ownerId,manager);
    }

    @DeleteMapping("/manager/{managerId}")
    public String DeleteManager(@PathVariable int managerId){
        return this.adminAvailableServices.DeleteManager(managerId);
    }

    // Manager can perform these operations i.e. manager can manage Staffs

    @PostMapping("/cook/{managerId}")
    public String AddCook(@PathVariable int managerId, @RequestBody CookingStaff cookingStaff){
        return this.adminAvailableServices.AddCook(managerId,cookingStaff);
    }

    @DeleteMapping("/cook/{c_id}")
    public String DeleteCook(@PathVariable int c_id){
        return this.adminAvailableServices.DeleteCook(c_id);
    }
    @GetMapping("/customer")
    public List<Customer> getCustomer(){
        return customerRepo.findAll();
    }

    @GetMapping("/roomInfo")
    public List<RoomAvailability> getRooms(){
        return  roomRepo.findAll();
    }
    @Autowired
    OrderRepo orderRepo;
    @GetMapping("/orders")
    public List<OrderTable> showOrders(){
        return orderRepo.findAll();
    }

    @Autowired
    InvoiceRepo invoiceRepo;

    @GetMapping("/invoice")
    public List <InvoiceTable> showInvoices(){
        return invoiceRepo.findAll();

    }
}
