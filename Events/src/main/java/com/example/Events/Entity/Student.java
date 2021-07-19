package com.example.Events.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int ID;
    private String Name;
    private String Department;
    private String Contact;

    public Student(){
    }
    public Student(int ID, String name, String department, String contact) {
        this.ID = ID;
        Name = name;
        Department = department;
        Contact = contact;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}