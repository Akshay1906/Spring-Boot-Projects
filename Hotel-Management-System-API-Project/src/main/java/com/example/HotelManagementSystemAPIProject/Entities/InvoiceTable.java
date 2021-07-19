package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceTable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int sr;

   long custId;
   int foodCharges;
   int roomCharges;
   int total;

   public InvoiceTable(){}

    public InvoiceTable(long custId, int foodCharges, int roomCharges, int total) {
        this.sr = sr;
        this.custId = custId;
        this.foodCharges = foodCharges;
        this.roomCharges = roomCharges;
        this.total = total;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public int getFoodCharges() {
        return foodCharges;
    }

    public void setFoodCharges(int foodCharges) {
        this.foodCharges = foodCharges;
    }

    public int getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(int roomCharges) {
        this.roomCharges = roomCharges;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
