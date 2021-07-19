package com.example.Course.services;

import com.example.Course.entity.Course;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class impl implements CourseServices{

    List <Course> list;
    public impl()
    {
        list = new ArrayList<>();
        list.add(new Course(1,"Java","Programming"));
        list.add(new Course(2,"Probability","Mathemeatics"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCoursesById(int id) {
        Course c = null;
        for(Course course:list)
        {
            if(course.getId() == id)
            {
                c = course;
                break;
            }

        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public String updateCourse(Course course) {

       for(Course e : list){
           if(e.getId() == course.getId()){
               e.setTitle(course.getTitle());
               e.setDesc(course.getDesc());
           }
       }
        return "Updated Successfully";
    }

    @Override
    public void deleteRecord(long parseLong){
        list = this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
    }


}
