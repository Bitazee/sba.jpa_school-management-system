package com.github.perscholas.model;

// TODO - Annotate and Implement respective interface and define behaviors

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;


@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "id")
    private int cId;

    @Basic
    @Column(name = "name")
    private String cName;

    @Basic
    @Column(name = "name")
    private String cInstructorName;

    public int getId() {
        return cId;
    }

    public void setId(int id) {
        this.cId = id;
    }

    public String getName() {
        return cName;
    }

    public void setName(String name) {
        this.cName = name;
    }

    public String getInstructor() {
        return cInstructorName;
    }

    public void setInstructor(String instructor) {
        cInstructorName = instructor;
    }
}
