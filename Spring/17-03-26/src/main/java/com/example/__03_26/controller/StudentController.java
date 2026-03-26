package com.example.__03_26.controller;

import com.example.__03_26.dto.StudentRequest;
import com.example.__03_26.dto.StudentResponse;
import com.example.__03_26.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    public StudentService studentservice;
    StudentController(StudentService studentService){
        this.studentservice=studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> getStudentDetails(){
        return ResponseEntity.ok(studentservice.findAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponse> addStudentDetails(@RequestBody StudentRequest request){
        return ResponseEntity.ok(studentservice.saveStudent(request));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponse> getStudentDetailsById(@PathVariable Long id){
        return ResponseEntity.ok(studentservice.findStudentsById(id));
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<StudentResponse>> getStudentDetailsByNameAndMinimumMarks(@RequestParam(required = false) String name,@RequestParam(required = false) Integer minMarks){
        return ResponseEntity.ok(studentservice.filterStudents(name,minMarks));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponse> updateStudentDetailsById(@PathVariable Long id,@RequestBody StudentRequest request){
        return ResponseEntity.ok(studentservice.updateStudent(id,request));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> DeleteStudentDetailsById(@PathVariable Long id){
        studentservice.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
