package com.edutech.progressive.service;

import com.edutech.progressive.entity.Course;

import java.util.List;

import org.springframework.stereotype.Service;

// @Service
public interface CourseService {

    public List<Course> getAllCourses()throws Exception;

    public Course getCourseById(int courseId)throws Exception;

    public Integer addCourse(Course course)throws Exception;

    public void updateCourse(Course course)throws Exception;

    public void deleteCourse(int courseId)throws Exception;

    //Do not implement these methods in CourseServiceImplJdbc.java class
    default public List<Course> getAllCourseByTeacherId(int teacherId) { return null; }
}
