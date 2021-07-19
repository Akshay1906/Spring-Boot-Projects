package com.example.HotelManagementSystemAPIProject.services;

import com.example.HotelManagementSystemAPIProject.Entities.Customer;
import com.example.HotelManagementSystemAPIProject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomerDetailService implements UserDetailsService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //get data from d/b

        Customer customer = customerRepo.findByEmail(email);

        if(customer != null){
            return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("User Not FOUND !!!");
        }

    }
}
