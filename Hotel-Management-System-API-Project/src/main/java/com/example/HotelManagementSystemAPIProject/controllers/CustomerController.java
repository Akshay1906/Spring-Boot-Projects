package com.example.HotelManagementSystemAPIProject.controllers;

import com.example.HotelManagementSystemAPIProject.Entities.*;
import com.example.HotelManagementSystemAPIProject.model.JwtRequest;
import com.example.HotelManagementSystemAPIProject.model.JwtResponse;
import com.example.HotelManagementSystemAPIProject.repository.*;
import com.example.HotelManagementSystemAPIProject.security.JwtUtil;
import com.example.HotelManagementSystemAPIProject.services.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private CustomerDetailService customerDetailService;

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    InvoiceRepo invoiceRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RoomBookinRepo roomBookinRepo;
    @PostMapping("/signup")
    public String RegisterCustomer(@RequestBody Customer customer){
        if(customerRepo.existsByEmail(customer.getEmail())){
            return "Email Already Exist";
        }
        System.out.println("ID :"+customer.getCustid());
        System.out.println("Name :"+customer.getName());
        System.out.println("Contact : "+customer.getContact());
        Customer customer1 = new Customer(customer.getCustid(),customer.getName(),customer.getEmail(),customer.getContact(),customer.getPassword());

        customerRepo.save(customer1);
        return "Customer Registered Successfully..........";

    }

   @PostMapping("/signin")
    public ResponseEntity<?> authenticateCustomer(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User NOt FOund Exception");
        }

        UserDetails userDetails = this.customerDetailService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT token::"+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/roomInfo")
    public List<RoomAvailability> getRooms(){
        System.out.println("lulli");
        return roomRepo.findAll();
    }

    @PostMapping("/bookRoom")
    public RoomBooking BookRoom(@RequestBody RoomBooking roomBooking) {
        List<RoomAvailability> l1 = roomRepo.findAll();

        System.out.println("Inside book Room ");

        if (roomBooking.getRoomType().equals("standard")) {
            System.out.println("Inside STandard room");
            for (RoomAvailability i : l1) {
                if (i.getSr_no() == 1 && i.getAvailable() != 0) {
                    System.out.println("Avaialable standard room  :: " + i.getAvailable());
                    i.setAvailable(i.getAvailable() - 1);
                    roomBookinRepo.save(roomBooking);
                    System.out.println("Standard Room Booked");
                    return roomBooking;
                }
            }

        } else if (roomBooking.getRoomType().equals("deluxe")) {
            System.out.println("Inside Deluxe Room");
            for (RoomAvailability i : l1) {
                if (i.getSr_no() == 2 && i.getAvailable() != 0) {
                    i.setAvailable(i.getAvailable() - 1);
                    roomBookinRepo.save(roomBooking);
                    return roomBooking;
                }
            }

        }
        return null;
    }

    @GetMapping("/getMeals")
    public List<FoodMenu> getMeals(){
        return foodRepo.findAll();
    }

    @PostMapping("/orderFood")
    public OrderTable orderFood(@RequestBody OrderTable orderRequest){

        List <FoodMenu> fetchDetails = foodRepo.findAll();
        int fetchFoodReqId = orderRequest.getFoodId();
        System.out.println("Fetch Food ID"+fetchFoodReqId);
        for(FoodMenu i:fetchDetails){
            System.out.println("i.GetPrice()::"+i.getPrice());
            if(i.getMenuID()==fetchFoodReqId){
                System.out.println("Inside IF");
                orderRequest.setPrice(orderRequest.getNo_of_items() * i.getPrice());
                orderRepo.save(orderRequest);
                System.out.println("Your Order Has Been Placed");
                return orderRequest;
            }
        }
        System.out.println("Something went wrong!!!!!!");
        return null;

    }
  @GetMapping("/invoice/{cust_id}")
    public InvoiceTable generateInvoice(@PathVariable int cust_id){
      List<OrderTable> list = orderRepo.findAll();
      List <RoomBooking> l2 = roomBookinRepo.findAll();
      int foodCharges = 0,roomCharges = 0;
      for(OrderTable i : list){
          if(i.getCustomer_Id()==cust_id){
              foodCharges = foodCharges+i.getPrice();
          }
      }

      // calculating room charges
      for(RoomBooking j: l2){
          if(cust_id == j.getCust_id() && j.getRoomType().equals("standard")){
              roomCharges = roomCharges + (j.getNo_of_days() * 1000);
          }
          else if(cust_id == j.getCust_id() && j.getRoomType().equals("deluxe")){
              roomCharges = roomCharges + (j.getNo_of_days() * 2000);
          }
      }
      InvoiceTable bill = new InvoiceTable(cust_id,foodCharges,roomCharges,(foodCharges+roomCharges));
      invoiceRepo.save(bill);
      return bill;
  }

}
