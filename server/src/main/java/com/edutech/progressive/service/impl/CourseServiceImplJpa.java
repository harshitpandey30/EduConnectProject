package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.repository.CourseRepository;
import com.edutech.progressive.service.CourseService;
// @Primary
@Service
public class CourseServiceImplJpa implements CourseService {
    // @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImplJpa(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAllCourses() throws Exception {
        return courseRepository.findAll();
        // return new ArrayList<>();
    }

    @Override
    public Course getCourseById(int courseId) throws Exception {
        return courseRepository.findByCourseId(courseId);
        // return null;
        
    }

    @Override
    public Integer addCourse(Course course) throws Exception {
    
       Course course1= courseRepository.save(course);
       return course1.getCourseId();
    //   return -1;
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) throws Exception {
        // if(!courseRepository.existsById(courseId)){
            // throw new RuntimeException("Course not found");
        // }
        // courseRepository.deleteById(courseId);
        if(courseRepository.existsById(courseId)){
            courseRepository.deleteById(courseId);
        }
        
    }

    @Override
    public List<Course> getAllCourseByTeacherId(int teacherId) {
        return courseRepository.findAllByTeacherId(teacherId);
        // return new ArrayList<>();
    }
    
    

}