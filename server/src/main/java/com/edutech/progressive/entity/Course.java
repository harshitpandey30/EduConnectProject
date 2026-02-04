package com.edutech.progressive.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private String description;
    @Column(name = "teacher_id",insertable = false,updatable = false)
    private Integer teacherId;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties({"courses"})
    private Teacher teacher;
    public Course(int courseId, String courseName, String description, int teacherId, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
        this.teacher = teacher;
    }
    public Course(String courseName, String description, int teacherId, Teacher teacher) {
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
        this.teacher = teacher;
    }
    public Course() {
    }
    public Course(String courseName, String description, int teacherId) {
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
    
}