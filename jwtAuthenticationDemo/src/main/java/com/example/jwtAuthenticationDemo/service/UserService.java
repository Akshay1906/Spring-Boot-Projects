package com.example.jwtAuthenticationDemo.service;

import com.example.jwtAuthenticationDemo.Entity.User;
import com.example.jwtAuthenticationDemo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // get user from d/b
        User user = userRepo.findByUsername(username);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("User Not Found");
        }

        /*if(username.equals("Akshay")){
            return new User("Akshay","Akshay@1906",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User Not found");
        }*/
    }
}
