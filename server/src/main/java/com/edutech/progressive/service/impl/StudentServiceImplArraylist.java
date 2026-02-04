package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;


@Service("studentServiceImplArraylist")
public class StudentServiceImplArraylist implements StudentService{
    static List<Student> studentList=new ArrayList<>();
    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Integer addStudent(Student student) {
        studentList.add(student);
        return (int)studentList.size();
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        Collections.sort(studentList,Comparator.comparing(Student::getFullName));
        return studentList;
    }
    public void emptyArrayList(){
        studentList.clear();
    }

    
}