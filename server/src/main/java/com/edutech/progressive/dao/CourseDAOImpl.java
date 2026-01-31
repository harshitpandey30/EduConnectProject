package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO{
    private Connection connection;

    
    public CourseDAOImpl()throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public int addCourse(Course course) throws SQLException{
        String sql="insert into course(course_name,description,teacher_id)values(?,?,?)";
        try (PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getTeacherId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } 
        return course.getCourseId();
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException{
        String sql="select * from course where course_id=?";
        Course c=null;
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1, courseId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                c=new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getInt("teacher_id"));
            }
        }
        return c;
    }

    @Override
    public void updateCourse(Course course) throws SQLException{
        String sql="update course set course_name=?,description=?,teacher_id=? where course_id=?";
        try (PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getTeacherId());
            ps.setInt(4, course.getCourseId());
            ps.executeUpdate();
        } 
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException{
        String sql="delete from course where course_id=?";
        try (PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, courseId);
            ps.executeUpdate();
        } 
    }

    @Override
    public List<Course> getAllCourses() throws SQLException{
        List<Course> l=new ArrayList<>();
        String sql="select * from course";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                l.add(new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getInt("teacher_id")));
            }
        }
        return l;
    }

}