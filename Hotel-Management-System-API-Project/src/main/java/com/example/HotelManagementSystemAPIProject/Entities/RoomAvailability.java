package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.*;

@Entity
public class RoomAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sr_no;
    @Column(nullable = false)
    String roomType;
    int no_of_rooms;
    int available;
    int price_per_day;

    public RoomAvailability(){}

    public RoomAvailability(int sr_no, String roomType, int no_of_rooms, int available, int price_per_day) {
        this.sr_no = sr_no;
        this.roomType = roomType;
        this.no_of_rooms = no_of_rooms;
        this.available = available;
        this.price_per_day = price_per_day;
    }

    public int getSr_no() {
        return sr_no;
    }

    public void setSr_no(int sr_no) {
        this.sr_no = sr_no;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(int price_per_day) {
        this.price_per_day = price_per_day;
    }
}
