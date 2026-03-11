package com.example.__02_26.controller;

import com.example.__02_26.repository.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    List<Student> studentsList=new ArrayList<>(List.of(
    new Student(1,"Jhon",20),
    new Student(2,"Kamala",21),
    new Student(3,"Bob",22)));

    @GetMapping()
    public List<Student> getStudents(){
        return studentsList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> fetchById(@PathVariable int id){
        for(Student obj:studentsList){
            if(id==obj.getID()){
                return ResponseEntity.status(HttpStatus.FOUND).body(obj);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/search")
    public ResponseEntity<Student> fetchbyName(@RequestParam String name){
        for(Student obj:studentsList){
            if(obj.getName().equalsIgnoreCase(name)){
                return ResponseEntity.ok(obj);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentsList.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student,@PathVariable int id){
        if(student.getID()==id) {
            for (Student obj : studentsList) {
                if (id == obj.getID()) {
                    obj.setName(student.getName());
                    obj.setAge(student.getAge());
                    return ResponseEntity.status(HttpStatus.FOUND).body(obj);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentDetails(@PathVariable int id){
        boolean removed=studentsList.removeIf(student -> student.getID()==id);
        if(removed){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

