package com.github.perscholas.model;

// TODO - Annotate and Implement respective interface and define behaviors

import javax.persistence.*;


@Entity
@Table(name = "Course")
public class Course implements CourseInterface {

    @Id
    @Column(name = "id")
    private int cId;

    @Basic
    @Column(name = "name")
    private String cName;

    @Basic
    @Column(name = "name")
    private String cInstructorName;

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public Integer getId() {
        return cId;
    }

    public void setId(Integer id) {
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
