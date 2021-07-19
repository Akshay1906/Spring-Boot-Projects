package com.example.HotelManagementSystemAPIProject.services;


import com.example.HotelManagementSystemAPIProject.Entities.CookingStaff;
import com.example.HotelManagementSystemAPIProject.Entities.Manager;
import com.example.HotelManagementSystemAPIProject.Entities.Owner;
import com.example.HotelManagementSystemAPIProject.repository.CookingStaffRepo;
import com.example.HotelManagementSystemAPIProject.repository.ManagerRepo;
import com.example.HotelManagementSystemAPIProject.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesImpl implements AdminAvailableServices {

    @Autowired
    OwnerRepo ownerRepo;
    @Autowired
    ManagerRepo managerRepo;

    @Autowired
    CookingStaffRepo cookingStaffRepo;

    @Override
    public List<Owner> GetOwner() {
        return ownerRepo.findAll();
    }

    @Override
    public List<Manager> GetManager() {
        return managerRepo.findAll();
    }

    @Override
    public String AddManager(int ownerId,Manager manager) {
        Optional<Owner> validate = ownerRepo.findById(ownerId);
        Optional <Manager> checkManagerId = managerRepo.findById(manager.getManagerId());
        if(validate.isPresent()){
            if(checkManagerId.isPresent())
                return "ID ALREADY EXIST !!!";
            else{
                managerRepo.save(manager);
                return "Manager Added Successfully";
            }
        }
        else{
            return "You are not Authorized !!!";
        }
    }

    @Override
    public String DeleteManager(int id) {
        Optional <Manager> validate = managerRepo.findById(id);
        if(validate.isPresent()){
            managerRepo.deleteById(id);
            return "Delete Operation Successfull";
        }
        else{
            return "Manager Not Present";
        }
    }

    @Override
    public String AddCook(int id, CookingStaff cookingStaff) {
        Optional <Manager> checkManagerId = managerRepo.findById(id);
        if(checkManagerId.isPresent()){
            cookingStaffRepo.save(cookingStaff);
            return "Cook Added Successfully";
        }else{
            return "You are not Authorized to perform this operation";
        }
    }

    @Override
    public String DeleteCook(int c_id) {
        Optional <CookingStaff> check = cookingStaffRepo.findById(c_id);
        if(check.isPresent()){
            cookingStaffRepo.deleteById(c_id);
            return "Deleted Successfully.......";
        }else{
            return  "Wrong Cook ID Entered";
        }
    }
}
