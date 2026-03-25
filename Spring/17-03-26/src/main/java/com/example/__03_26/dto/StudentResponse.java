package com.example.__03_26.dto;

public class StudentResponse {
    public Long id;
    public String name;
    public int marks;

    public StudentResponse(Long id, String name, int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
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
