package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
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
    private Connection connection;
    public StudentDAOImpl() throws SQLException{
        this.connection = DatabaseConnectionManager.getConnection();
    }
    @Override
    public int addStudent(Student student) throws SQLException {
        String sql="insert into student (full_name,date_of_birth,contact_number,email,address)values(?,?,?,?,?)";
        try (PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, student.getFullName());
            ps.setDate(2, new Date(student.getDateOfBirth().getTime()));
            ps.setString(3, student.getContactNumber());
            ps.setString(4,student.getEmail());
            ps.setString(5,student.getAddress());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        }
        return student.getStudentId();
    }
    @Override
    public Student getStudentById(int studentId) throws SQLException {
        String sql="SELECT * FROM student WHERE student_id=?";
        Student student=null;
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1, studentId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                student=new Student(
                    rs.getInt("student_id"), 
                    rs.getString("full_name"), 
                    rs.getDate("date_of_birth"), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getString("address")
                );
            }
        }
        return student;

    }
    @Override
    public void updateStudent(Student student) throws SQLException{
        String sql="update student set full_name=?,date_of_birth=?,contact_number=?,email=?,address=? where student_id=?";
        try (PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setString(1, student.getFullName());
            ps.setDate(2, new Date(student.getDateOfBirth().getTime()));
            ps.setString(3, student.getContactNumber());
            ps.setString(4,student.getEmail());
            ps.setString(5,student.getAddress());
            ps.setInt(6, student.getStudentId());
            ps.executeUpdate();
        }

    }
    @Override
    public void deleteStudent(int studentId) throws SQLException{
        String sql="delete from student where student_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1, studentId);
            ps.executeUpdate();
        }
    }
    @Override
    public List<Student> getAllStudents() throws SQLException{
        List<Student> l=new ArrayList<>();
        String sql="SELECT * FROM student";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                l.add(new Student(
                    rs.getInt("student_id"), 
                    rs.getString("full_name"), 
                    rs.getDate("date_of_birth"), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getString("address")
                ));
            }
        }
        return l;
    }
}
