package com.edutech.progressive.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.repository.CourseRepository;
import com.edutech.progressive.repository.TeacherRepository;
import com.edutech.progressive.service.TeacherService;

@Service
public class TeacherServiceImplJpa implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    

    public TeacherServiceImplJpa(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }
    

    public TeacherServiceImplJpa() {
    }


    public TeacherServiceImplJpa(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherRepository.findAll();
    }

    @Override
    public Integer addTeacher(Teacher teacher) throws Exception {
        return teacherRepository.save(teacher).getTeacherId();
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() throws Exception {
        return teacherRepository.findAll(Sort.by("experience"));
    }

    @Override
    public void deleteTeacher(int teacherId) throws Exception {
        courseRepository.deleteByTeacherId(teacherId);
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws Exception {
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        Teacher teach=getTeacherById(teacher.getTeacherId());
        teach.setContactNumber(teacher.getContactNumber());
        teach.setCourses(teacher.getCourses());
        teach.setEmail(teacher.getEmail());
        teach.setFullName(teacher.getFullName());
        teach.setSubject(teacher.getSubject());
        teach.setYearsOfExperience(teacher.getYearsOfExperience());
        teacherRepository.save(teach);
    }
    

}