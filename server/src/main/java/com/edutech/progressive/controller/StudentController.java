package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;

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
import java.util.Comparator;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {
    // @Autowired
    StudentService studentService;
    
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //----------------------------------------


    @GetMapping
    public List<Student> getAllStudents()throws Exception {
        return new ArrayList<>();
        // return null;
        //return ResponseEntity.status(200).body(new ArrayList<>());
    }
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) throws Exception {
        return null;
        //return ResponseEntity.status(200).body(studentService.getStudentById(studentId));
    }
    @PostMapping
    public int addStudent(@RequestBody Student student)throws Exception  {
        //return ResponseEntity.status(200).body(studentService.addStudent(student));
        return -1;
    }
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable int studentId,@RequestBody Student student)throws Exception  {
        //return ResponseEntity.noContent().build();
        //studentService.updateStudent(student);
        //return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId)throws Exception  {
        //return ResponseEntity.noContent().build();
        //studentService.deleteStudent(studentId);
        //return ResponseEntity.status(200).build();
    }
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Student>> getAllStudentFromArrayList()throws Exception {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
        //return null;
    }
    @PostMapping("/toArrayList")
    @ResponseStatus(HttpStatus.CREATED)
    public int addStudentToArrayList(@RequestBody Student student) throws Exception{
        //return -1;
        //return ResponseEntity.status(201).body(-1);
        return studentService.addStudent(student);
    }
    @GetMapping("/fromArrayList/sorted")
    public List<Student> getAllStudentSortedByNameFromArrayList() throws Exception{
        List<Student> list=new ArrayList<>(studentService.getAllStudents());
        list.sort(Comparator.comparing(Student::getFullName,String.CASE_INSENSITIVE_ORDER));
        return list;
        // return null;
        //return ResponseEntity.status(200).body(new ArrayList<>());
    }


    //-----------------------------------------


    // @GetMapping
    // public ResponseEntity<List<Student>> getAllStudents()throws Exception {
    //     //return null;
    //     return ResponseEntity.status(200).body(new ArrayList<>());
    // }
    // @GetMapping("/{studentId}")
    // public ResponseEntity<Student> getStudentById(@PathVariable int studentId) throws Exception {
    //     //return null;
    //     return ResponseEntity.status(200).body(studentService.getStudentById(studentId));
    // }
    // @PostMapping
    // public ResponseEntity<Integer> addStudent(@RequestBody Student student)throws Exception  {
    //     return ResponseEntity.status(200).body(studentService.addStudent(student));
    //     //return -1;
    // }
    // @PutMapping("/{studentId}")
    // public ResponseEntity<Void> updateStudent(@PathVariable int studentId,@RequestBody Student student)throws Exception  {
    //     return ResponseEntity.noContent().build();
    //     //studentService.updateStudent(student);
    //     //return ResponseEntity.status(200).build();
    // }
    // @DeleteMapping("/{studentId}")
    // public ResponseEntity<Void> deleteStudent(@PathVariable int studentId)throws Exception  {
    //     return ResponseEntity.noContent().build();
    //     //studentService.deleteStudent(studentId);
    //     //return ResponseEntity.status(200).build();
    // }
    // @GetMapping("/fromArraylist")
    // public ResponseEntity<List<Student>> getAllStudentFromArrayList()throws Exception {
    //     return ResponseEntity.status(200).body(new ArrayList<>());
    //     //return studentService.getAllStudents();
    // }
    // @PostMapping("/toArraylist")
    // public ResponseEntity<Integer> addStudentToArrayList(Student student) throws Exception{
    //     return ResponseEntity.status(201).body(-1);
    //     //return studentService.addStudent(student);
    // }
    // @GetMapping("/fromArraylist/sorted")
    // public ResponseEntity<List<Student>> getAllStudentSortedByNameFromArrayList() throws Exception{
    //     //return null;
    //     //return studentService.getAllStudentSortedByName();
    //     return ResponseEntity.status(200).body(new ArrayList<>());
    // }
}