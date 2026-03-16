package com.example.__03_26.repository;

import com.example.__03_26.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    Void deleteById(long id);

    Student findByIdGreaterThan(int id);
    Student findAllByNameContaining(String subsstring);
    Optional<Student> countByMarks(int marks);
    List<Student> findByNameAndMarksGreaterThan(String name, int marks);

    @Query("select s from Student s where s.marks> :marks")
    List<Student> findByMarksGreaterThan(@Param("marks") int marks);
}
