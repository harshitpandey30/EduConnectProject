package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.service.CourseService;
import com.edutech.progressive.service.impl.CourseServiceImplJpa;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;
    
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping
    public List<Course> getAllCourses() throws Exception{
         return courseService.getAllCourses();
        //return null;
    }
    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable int courseId) throws Exception{
         return courseService.getCourseById(courseId);
        //return null;
    }
    @PostMapping
    public int addCourse(@RequestBody Course course) throws Exception{
        return courseService.addCourse(course);
        //return -1;
    }
    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable int courseId,@RequestBody Course course) throws Exception{
        course.setCourseId(courseId);
        courseService.updateCourse(course);
    }
    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId) throws Exception{
        courseService.deleteCourse(courseId);
    }
    @GetMapping("/teacher/{teacherId}")
    public List<Course> getAllCourseByTeacherId(@PathVariable int teacherId) throws Exception{
        return courseService.getAllCourseByTeacherId(teacherId);
        // return null;
    }
    // private CourseServiceImplJpa courseServiceImplJpa;
    


    // public CourseController(CourseServiceImplJpa courseServiceImplJpa) {
    //     this.courseServiceImplJpa = courseServiceImplJpa;
    // }
    
    // @GetMapping
    // public List<Course> getAllCourses() throws Exception{
    //     return courseServiceImplJpa.getAllCourses();
    // }
    // @GetMapping("/{courseId}")
    // public Course getCourseById(@PathVariable int courseId) throws Exception{
    //     return courseServiceImplJpa.getCourseById(courseId);
    // }
    // @PostMapping
    // public int addCourse(@RequestBody Course course) throws Exception{
    //     return courseServiceImplJpa.addCourse(course);
    // }
    // @PutMapping("/{courseId}")
    // public void updateCourse(@PathVariable int courseId,@RequestBody Course course) throws Exception{
    //     course.setCourseId(courseId);
    //     courseServiceImplJpa.updateCourse(course);
    // }
    // @DeleteMapping("/{courseId}")
    // public void deleteCourse(@PathVariable int courseId) throws Exception{
    //     courseServiceImplJpa.deleteCourse(courseId);
    // }
    // @GetMapping("/teacher/{teacherId}")
    // public List<Course> getAllCourseByTeacherId(@PathVariable int teacherId) throws Exception{
    //     return courseServiceImplJpa.getAllCourseByTeacherId(teacherId);
    // }
    // private CourseService courseService;
    
    // public CourseController(CourseService courseService) {
    //     this.courseService = courseService;
    // }
    // @GetMapping
    // public ResponseEntity<List<Course>> getAllCourses() throws Exception{
    //     return ResponseEntity.status(200).body(courseService.getAllCourses());
    // }
    // @GetMapping("/{id}")
    // public ResponseEntity<Course> getCourseById(@PathVariable int courseId) throws Exception{
    //     return ResponseEntity.status(200).body(courseService.getCourseById(courseId));
    // }
    // @PostMapping
    // public ResponseEntity<Integer> addCourse(@RequestBody Course course) throws Exception{
    //     return ResponseEntity.status(200).body(courseService.addCourse(course));
    // }
    // @PutMapping("/{id}")
    // public ResponseEntity<Void> updateCourse(@PathVariable int courseId,@RequestBody Course course) throws Exception{
    //     courseService.updateCourse(course);
    //     return ResponseEntity.status(200).build();
    // }
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) throws Exception{
    //     courseService.deleteCourse(courseId);
    //     return ResponseEntity.status(200).build();
    // }
    // @GetMapping("/teacher/{teacherId}")
    // public ResponseEntity<List<Course>> getAllCourseByTeacherId(@PathVariable int teacherId) throws Exception{
    //     return ResponseEntity.status(200).body(courseService.getAllCourseByTeacherId(teacherId));
    // }
}
