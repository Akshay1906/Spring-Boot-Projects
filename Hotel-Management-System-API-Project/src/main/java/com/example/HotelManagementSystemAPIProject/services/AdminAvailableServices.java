package com.example.HotelManagementSystemAPIProject.services;
import com.example.HotelManagementSystemAPIProject.Entities.CookingStaff;
import com.example.HotelManagementSystemAPIProject.Entities.Manager;
import com.example.HotelManagementSystemAPIProject.Entities.Owner;

import java.util.List;

public interface AdminAvailableServices {

    public List<Owner> GetOwner();
    public List <Manager> GetManager();
    public String AddManager(int id,Manager manager);
    public String DeleteManager(int id);
    public String AddCook(int id, CookingStaff cookingStaff);
    public String DeleteCook(int c_id);
}
