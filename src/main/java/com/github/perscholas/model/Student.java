package com.github.perscholas.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Student")
public class Student implements  StudentInterface{

    @Id
    @Column(name = "email")
    private String sEmail;

    @Basic
    @Column(name = "name")
    private String sName;

    @Basic
    @Column(name = "password")
    private String sPass;

    private List<CourseInterface> sCoures;

    public Student(String email, String name, String pass){
        sEmail = email;
        sName = name;
        sPass = pass;
    }
    @Override
    public String getEmail() {
        return sEmail;
    }

    @Override
    public String getName() {
        return sName;
    }

    @Override
    public String getPassword() {
        return sPass;
    }

    @Override
    public void setEmail(String email) {
        this.sEmail = email;
    }

    @Override
    public void setName(String name) {
        this.sName = name;
    }

    @Override
    public void setPassword(String password) {
        this.sPass = password;
    }

    public List<CourseInterface> getsCoures() {
        return sCoures;
    }

    public void setsCoures(List<CourseInterface> sCoures) {
        this.sCoures = sCoures;
    }
}
