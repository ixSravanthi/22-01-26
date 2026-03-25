package com.example.__03_26.mapper;

import com.example.__03_26.dto.StudentRequest;
import com.example.__03_26.dto.StudentResponse;
import com.example.__03_26.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapToRequest(StudentRequest request){
        Student student=new Student();
        student.setName(request.getName());
        student.setMarks(request.getMarks());
        return student;
    }

    public StudentResponse mapToResponse(Student student){
        return new StudentResponse(student);
    }
}
