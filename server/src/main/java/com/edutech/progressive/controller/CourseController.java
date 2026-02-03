package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.service.CourseService;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() throws Exception{
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int courseId) throws Exception{
        return ResponseEntity.status(200).body(courseService.getCourseById(courseId));
    }
    @PostMapping
    public ResponseEntity<Integer> addCourse(@RequestBody Course course) throws Exception{
        return ResponseEntity.status(200).body(courseService.addCourse(course));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable int courseId,@RequestBody Course course) throws Exception{
        courseService.updateCourse(course);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) throws Exception{
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Course>> getAllCourseByTeacherId(@PathVariable int teacherId) throws Exception{
        return ResponseEntity.status(200).body(courseService.getAllCourseByTeacherId(teacherId));
    }
}
