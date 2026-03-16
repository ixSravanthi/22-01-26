package com.example.__03_26.controller;

import com.example.__03_26.entity.Student;
import com.example.__03_26.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    public StudentRepository repo;

    public StudentController(StudentRepository repo){
        this.repo=repo;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> displayStudents(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable long id){
        Optional<Student> studentOptional = repo.findById(id);
        return studentOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Student> getByStudentNameAndMarks(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) Integer marks){
        if (name != null && marks != null) {
            return repo.findByNameAndMarksGreaterThan(name, marks);
        } else if (name != null) {
            return repo.findByName(name);
        } else if (marks != null) {
            return repo.findByMarksGreaterThan(marks);
        } else {
            return repo.findAll();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudents(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable long id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
