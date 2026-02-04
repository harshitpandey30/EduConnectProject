package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //List<Student> findAllByOrderByFullNameAsc();
    Student findByStudentId(int studentId);
}
