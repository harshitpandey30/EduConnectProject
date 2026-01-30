package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.TeacherDAO;
import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.TeacherService;

public class TeacherServiceImplJdbc  implements TeacherService{
    List<Teacher> l=new ArrayList<>();

    @Override
    public List<Teacher> getAllTeachers() {
        
        return l;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return -1;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        return l;
    }


}