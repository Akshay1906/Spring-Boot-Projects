package com.example.jwtAuthenticationDemo.Repository;

import com.example.jwtAuthenticationDemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository <User, Integer> {
    User findByUsername(String user);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);


}
