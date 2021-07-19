package com.example.Events.Dao;

import com.example.Events.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository <Student, Integer> {
}


