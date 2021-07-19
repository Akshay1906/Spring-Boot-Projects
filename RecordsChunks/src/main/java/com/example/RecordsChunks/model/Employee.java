package com.example.RecordsChunks.model;

public class Employee {

    private String empId,fname,lname,email,phoneNo,country,city,state;

    public Employee(){}
    public Employee(String empId, String fname, String lname, String email, String phoneNo, String country, String city, String state) {
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
        this.city = city;
        this.state = state;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
