package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

   @Id
   long custid;

   String name,email,contact,password;

    public Customer(){}
    public Customer(long custid, String name, String email, String contact, String password) {
        this.custid = custid;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public long getCustid() {
        return custid;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
