package com.example.__03_26.dto;

import com.example.__03_26.entity.Student;

public class StudentResponse {
    public Long id;
    public String name;
    public int marks;

    public StudentResponse(Student student){
        this.id= student.getId();
        this.name= student.getName();
        this.marks= student.getMarks();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
