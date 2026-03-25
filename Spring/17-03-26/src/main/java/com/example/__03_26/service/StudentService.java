package com.example.__03_26.service;

import com.example.__03_26.dto.StudentRequest;
import com.example.__03_26.dto.StudentResponse;
import com.example.__03_26.entity.Student;
import com.example.__03_26.mapper.StudentMapper;
import com.example.__03_26.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    public StudentRepository studentrepository;
    public StudentMapper studentmapper;

    public StudentService(StudentRepository studentrepository, StudentMapper studentmapper) {
        this.studentrepository = studentrepository;
        this.studentmapper=studentmapper;
    }

    @Transactional
    public StudentResponse saveStudent(StudentRequest request) {
        Student student = studentmapper.mapToRequest(request);
        return studentmapper.mapToResponse(studentrepository.save(student));
    }

    public StudentResponse findStudentsById(Long id) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentmapper.mapToResponse(student);
    }

    public List<StudentResponse> findAllStudents() {
        return studentrepository.findAll()
                .stream()
                .map(studentmapper::mapToResponse)
                .toList();    }

    public List<StudentResponse> filterStudents(String name, Integer minMarks) {
        return studentrepository.findAll().stream()
                .filter(s -> name == null || s.getName().contains(name))
                .filter(s -> minMarks == null || s.getMarks() >= minMarks)
                .map(studentmapper::mapToResponse)
                .toList();
    }

    @Transactional
    public StudentResponse updateStudent(Long id, StudentRequest studentrequest) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentrequest.getName());
        student.setMarks(studentrequest.getMarks());

        Student updated = studentrepository.save(student);
//        throw new RuntimeException("Update failed");
        return studentmapper.mapToResponse(updated);
    }

    @Transactional
    public void deleteStudent(Long id) {
        if (!studentrepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
//        throw new RuntimeException("Delete failed");
        studentrepository.deleteById(id);    }
}
