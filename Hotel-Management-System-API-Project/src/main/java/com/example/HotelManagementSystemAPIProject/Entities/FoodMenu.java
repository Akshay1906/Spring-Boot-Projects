package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.*;

@Entity
public class FoodMenu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int menuID;
    @Column(nullable = false)
    String item;
    @Column(nullable = false)
    int price;
    
    public FoodMenu(){}

    public FoodMenu(int menuID, String item, int price) {
        this.menuID = menuID;
        this.item = item;
        this.price = price;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
