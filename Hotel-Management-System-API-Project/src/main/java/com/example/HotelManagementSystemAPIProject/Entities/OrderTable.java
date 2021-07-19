package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int serial_no;

    long customer_Id;
    int foodId,no_of_items;
    int price;



    public OrderTable(){}

    public OrderTable(int serial_no, long customer_Id, int foodId, int no_of_items, int price) {
        this.serial_no = serial_no;
        this.customer_Id = customer_Id;
        this.foodId = foodId;
        this.no_of_items = no_of_items;
        this.price = price;

    }

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public long getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(long customer_Id) {
        this.customer_Id = customer_Id;
    }


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public void setNo_of_items(int no_of_items) {
        this.no_of_items = no_of_items;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
