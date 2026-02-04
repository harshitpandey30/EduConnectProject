package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.StudentDTO;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.repository.StudentRepository;
import com.edutech.progressive.service.StudentService;

@Service("studentServiceImplJpa")
public class StudentServiceImplJpa implements StudentService {
    private StudentRepository studentRepository;
    
    public StudentServiceImplJpa(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        return studentRepository.save(student).getStudentId();
    }

    
    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> l=new ArrayList<>(studentRepository.findAll());
        Collections.sort(l);
        return l;
    }

    @Override
    public void deleteStudent(int studentId) throws Exception {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public void modifyStudentDetails(StudentDTO studentDTO) {
        // Student student=studentRepository.findById(studentDTO.getStudentId()).orElse(null);
        // if(student!=null){
        //     student.setFullName(studentDTO.getFullName());
        //     student.setEmail(studentDTO.getEmail());
        //     studentRepository.save(student);
        // }
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentRepository.save(student);
    }
}