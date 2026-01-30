package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Student;

public class StudentDAOImpl implements StudentDAO{
    // private Connection connection;
    // public StudentDAOImpl() {
    //     try {
    //         this.connection = DatabaseConnectionManager.getConnection();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    @Override
    public int addStudent(Student student) {
        // String sql="insert into student (full_name,date_of_birth,contact_number,email,address)values(?,?,?,?,?)";
        // try (PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
        //     ps.setString(1, student.getFullName());
        //     ps.setDate(2, student.getDateOfBirth());
        //     ps.setString(3, student.getContactNumber());
        //     ps.setString(4,student.getEmail());
        //     ps.setString(5,student.getAddress());
        //     ps.executeUpdate();
        //     ResultSet rs=ps.getGeneratedKeys();
        //     if(rs.next()){
        //         return rs.getInt(1);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return -1;
    }
    @Override
    public Student getStudentById(int studentId) {
        // String sql="SELECT * FROM student WHERE student_id=?";
        return null;

    }
    @Override
    public void updateStudent(Student student) {
        
    }
    @Override
    public void deleteStudent(int studentId) {
        
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> l=new ArrayList<>();
        return l;
    }
}
