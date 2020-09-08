package com.github.perscholas.service;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.dao.StudentDao;
import com.github.perscholas.model.CourseInterface;
import com.github.perscholas.model.Student;
import com.github.perscholas.model.StudentInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO - Implement respective DAO interface
public class StudentService implements StudentDao {
    private final DatabaseConnection dbc;

    public StudentService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public StudentService() {
        this(DatabaseConnection.UAT);
    }

    @Override
    public List<StudentInterface> getAllStudents() {
        ResultSet resultSet = dbc.executeQuery("SELECT * FROM Student");
        try {
            List<StudentInterface> listOfStudents = new ArrayList<>();
            while(resultSet.next()){
                listOfStudents.add(
                        new Student(
                                resultSet.getString("email"),
                                resultSet.getString("name"),
                                resultSet.getString("password")
                        )
                );
            }
            return listOfStudents;
        } catch(SQLException e) {
            throw new Error(e);
        }
    }

    @Override
    public StudentInterface getStudentByEmail(String studentEmail) {
        ResultSet resultSet = dbc.executeQuery("Select From Student Where email = {studentEmail}");
        try{
            return null;
        }
        catch(Exception e){
            throw new Error(e);
        }
    }

    @Override
    public Boolean validateStudent(String studentEmail, String password) {
        try {
            ResultSet resultSet = dbc.executeQuery("Select From Student Where email = {studentEmail} and password = {password}");
            if(!resultSet.next()){
                System.out.println("Student does not exist in the database");
                return false;
            }
            else{
                return true;
            }
        } catch(Exception e) {
            throw new Error(e);
        }
    }

    @Override
    public void registerStudentToCourse(String studentEmail, int courseId) {
        try {

        } catch(Exception e) {
            throw new Error(e);
        }
    }

    @Override
    public List<CourseInterface> getStudentCourses(String studentEmail) {
        try {
            return null; // TODO - Parse `List<StudentInterface>` from `resultSet`
        } catch(Exception e) {
            throw new Error(e);
        }
    }
}
