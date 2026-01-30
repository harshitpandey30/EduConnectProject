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
        return -1;
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException{
        return null;
    }

    @Override
    public void updateCourse(Course course) throws SQLException{
        
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException{
        
    }

    @Override
    public List<Course> getAllCourses() throws SQLException{
        List<Course> l=new ArrayList<>();
        return l;
    }

}