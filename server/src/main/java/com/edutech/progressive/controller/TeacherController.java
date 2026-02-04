package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.TeacherService;
import com.edutech.progressive.service.impl.TeacherServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    TeacherServiceImplJpa teacherServiceImplJpa;
    
    public TeacherController(TeacherServiceImplJpa teacherServiceImplJpa) {
        this.teacherServiceImplJpa = teacherServiceImplJpa;
    }
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() throws Exception{
        return ResponseEntity.status(200).body(teacherServiceImplJpa.getAllTeachers());
    }
    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId)throws Exception {
        return ResponseEntity.status(200).body(teacherServiceImplJpa.getTeacherById(teacherId));
    }
    @PostMapping
    public ResponseEntity<Integer> addTeacher(@RequestBody Teacher teacher) throws Exception{
        return ResponseEntity.status(201).body(teacherServiceImplJpa.addTeacher(teacher));
    }
    @PutMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeacher(@PathVariable int teacherId,@RequestBody Teacher teacher) throws Exception{
        teacher.setTeacherId(teacherId);
        teacherServiceImplJpa.updateTeacher(teacher);
    }
    @DeleteMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable int teacherId) throws Exception{
        teacherServiceImplJpa.deleteTeacher(teacherId);
    }
    @GetMapping("/sorted")
    public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience() throws Exception{
        return ResponseEntity.status(200).body(teacherServiceImplJpa.getTeacherSortedByExperience());
    }
    // private TeacherService teacherService;
    
    // public TeacherController(TeacherService teacherService) {
    //     this.teacherService = teacherService;
    // }
    // @GetMapping
    // public ResponseEntity<List<Teacher>> getAllTeachers() throws Exception{
    //     return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    // }
    // @GetMapping("/{id}")
    // public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId)throws Exception {
    //     return ResponseEntity.status(200).body(teacherService.getTeacherById(teacherId));
    // }
    // @PostMapping
    // public ResponseEntity<Integer> addTeacher(@RequestBody Teacher teacher) throws Exception{
    //     return ResponseEntity.status(200).body(teacherService.addTeacher(teacher));
    // }
    // @PutMapping("/{id}")
    // public ResponseEntity<Void> updateTeacher(@PathVariable int teacherId,@RequestBody Teacher teacher) throws Exception{
    //     teacherService.updateTeacher(teacher);
    //     return ResponseEntity.status(200).build();
    // }
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherId) throws Exception{
    //     teacherService.deleteTeacher(teacherId);
    //     return ResponseEntity.status(200).build();
    // }
    // @GetMapping("/sorted")
    // public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience() throws Exception{
    //     return ResponseEntity.status(200).body(teacherService.getTeacherSortedByExperience());
    // }
}
