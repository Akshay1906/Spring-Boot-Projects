package com.example.HotelManagementSystemAPIProject.Entities;

import javax.persistence.*;

@Entity
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long bookId;
    @Column(nullable = false)
    String roomType;
    @Column(nullable = false)
    long cust_id;
    @Column(nullable = false)
    int no_of_days;

    public RoomBooking(){}

    public RoomBooking(long bookId, String roomType, long cust_id, int no_of_days) {
        this.bookId = bookId;
        this.roomType = roomType;
        this.cust_id = cust_id;
        this.no_of_days = no_of_days;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }
}
