package com.example.HotelManagementSystemAPIProject.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private  int managerId;
    @Column(nullable = false)
    private String mname,memail,mcontact, maddress;

    public Manager(){}

    public Manager(int managerId, String mname, String memail, String mcontact, String maddress) {
        this.managerId = managerId;
        this.mname = mname;
        this.memail = memail;
        this.mcontact = mcontact;
        this.maddress = maddress;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMcontact() {
        return mcontact;
    }

    public void setMcontact(String mcontact) {
        this.mcontact = mcontact;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }
}
