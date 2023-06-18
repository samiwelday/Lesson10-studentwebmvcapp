package edu.miu.cs.cs425.studentcliapp.repository;

import edu.miu.cs.cs425.studentcliapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllStudentByFirstNameContainingIgnoreCase(String name);

}
