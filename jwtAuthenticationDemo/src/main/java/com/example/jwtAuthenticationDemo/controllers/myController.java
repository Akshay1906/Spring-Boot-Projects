package com.example.jwtAuthenticationDemo.controllers;

import com.example.jwtAuthenticationDemo.Entity.User;
import com.example.jwtAuthenticationDemo.Repository.UserRepo;
import com.example.jwtAuthenticationDemo.model.JwtRequest;
import com.example.jwtAuthenticationDemo.model.JwtResponse;
import com.example.jwtAuthenticationDemo.security.JwtUtil;
import com.example.jwtAuthenticationDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

   @Autowired
    UserRepo userRepo;

  /* @Autowired
   PasswordEncoder encoder;*/

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);

        try{
           this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User NOt FOund Exception");
        }

        UserDetails userDetails = this.userService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT token::"+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody User userRequest){
        if(userRepo.existsByEmail(userRequest.getEmail())){
            return ("Email Already Exists !!");
        }
        if(userRepo.existsByUsername(userRequest.getUsername())){
            return ("Username Already exist");

        }

        User user = new User(userRequest.getUsername(),
                userRequest.getEmail(),userRequest.getPassword());

        userRepo.save(user);
        return ("Registered Successfully..........");
    }

}
