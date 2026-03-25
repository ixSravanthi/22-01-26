package com.example.__03_26.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "student_name", nullable = false, length = 50)
    private String name;
    @Column(name="student_marks")
    private int marks;

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
