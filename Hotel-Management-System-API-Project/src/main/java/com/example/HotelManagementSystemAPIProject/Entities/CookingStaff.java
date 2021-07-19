package com.example.HotelManagementSystemAPIProject.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CookingStaff {
    @Id
    int c_id;
    @Column(nullable = false)
    String c_name,c_contact,c_address;

    public CookingStaff(){}

    public CookingStaff(int c_id, String c_name, String c_contact, String c_address) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_contact = c_contact;
        this.c_address = c_address;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_contact() {
        return c_contact;
    }

    public void setC_contact(String c_contact) {
        this.c_contact = c_contact;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }
}
