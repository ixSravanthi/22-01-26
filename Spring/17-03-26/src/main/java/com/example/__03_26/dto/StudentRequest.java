package com.example.__03_26.dto;

public class StudentRequest {
    String name;
    int marks;

    public StudentRequest(){}

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
