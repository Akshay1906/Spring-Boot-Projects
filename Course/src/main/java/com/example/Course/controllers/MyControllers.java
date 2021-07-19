package com.example.Course.controllers;


import com.example.Course.entity.Course;
import com.example.Course.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyControllers {

    @Autowired
    public CourseServices courseServices;

    @GetMapping("/home")
    public String home()
    {
        return "Hello I am in Home Page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseServices.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId)
    {
        return this.courseServices.getCoursesById(Integer.parseInt(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseServices.addCourse(course);
    }
    @PutMapping("/courses")
    public String updateCourse(@RequestBody Course course){
        return this.courseServices.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseID}")
    public void deleteRecord(@PathVariable String courseId)
    {
         this.courseServices.deleteRecord(Long.parseLong(courseId));
    }
}
