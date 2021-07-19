package com.example.Events.Services;

import com.example.Events.Dao.StudentDao;
import com.example.Events.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImpl implements AvailServices{
    @Autowired
    private StudentDao studentDao;



    @Override
    public List<Student> getData() {
        return studentDao.findAll();
    }

    @Override
    public String createUser() {
        Student s1 = new Student(12,"Akshay","Ksolves","8617565871");
        Student s2 = new Student(12,"Rishi","MCA","9876543210");
        studentDao.save(s1);
        studentDao.save(s2);
        return "Sucessfulyy registered..............";
    }
}
