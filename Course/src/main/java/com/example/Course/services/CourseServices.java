package com.example.Course.services;

import com.example.Course.entity.Course;

import java.util.List;

public interface CourseServices {

    public List<Course>  getCourses();
    public Course getCoursesById(int id);

    public Course addCourse(Course course);

    public String updateCourse(Course course);

    public void deleteRecord(long id);
}
