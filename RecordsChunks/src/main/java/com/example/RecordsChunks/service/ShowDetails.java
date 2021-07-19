package com.example.RecordsChunks.service;

import com.example.RecordsChunks.model.Employee;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ShowDetails {
    public static List<Employee> getEmployee(String pageSize, String pageNo) throws IOException {
        int pSize = Integer.parseInt(pageSize);
        int pNo = Integer.parseInt(pageNo);
        long count = 0;

        ArrayList<String>list =new ArrayList<String>();
        String filepath = "C:\\Users\\Akshay\\Desktop\\Hr1m.csv";

        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
        String row;


        while((row = csvReader.readLine()) != null){
            //list of string
            list.add(row);
            count++;
        }
        System.out.println("COUNT::"+count);
        System.out.println("List Length::"+list.size());

        ArrayList<Employee> str = new ArrayList<Employee>();

        for(int i = 0; i < pSize; i++){
            String element = list.get(pNo*10+i);
            String data[] = element.split(",");
            Employee emp = new Employee();
            emp.setEmpId(data[0]);
            emp.setFname(data[1]);
            emp.setLname(data[2]);
            emp.setEmail(data[3]);
            emp.setPhoneNo(data[4]);
            emp.setCountry(data[5]);
            emp.setCity(data[6]);
            emp.setState(data[7]);

            str.add(emp);
        }
        return str;
    }
}
