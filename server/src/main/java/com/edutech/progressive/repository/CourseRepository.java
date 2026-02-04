package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    //List<Course> findByTeacherId(int teacherId);
    Course findByCourseId(int courseId);
    List<Course> findAllByTeacherId(int teacherId);
    void deleteByTeacherId(int teacherId);
}
