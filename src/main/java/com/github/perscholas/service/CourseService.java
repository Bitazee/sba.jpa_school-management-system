package com.github.perscholas.service;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.dao.CourseDao;

import com.github.perscholas.model.CourseInterface;

import java.sql.ResultSet;
import java.util.List;

// TODO - Implement respective DAO interface
public class CourseService implements CourseDao {
    private final DatabaseConnection dbc;

    public CourseService(DatabaseConnection dbc){
        this.dbc = dbc;
    }
    public CourseService(){
        this(DatabaseConnection.UAT);
    }
    public List<CourseInterface> getAllCourses(){
        ResultSet resultSet = dbc.executeQuery("SELECT * FROM Course");
        return null;
    }
}
