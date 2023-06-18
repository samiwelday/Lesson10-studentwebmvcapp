package edu.miu.cs.cs425.studentcliapp.service;


import edu.miu.cs.cs425.studentcliapp.model.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(Student newstudent);

    List<Student> getAllStudents();


    List<Student> getAllStudentsSorted();

    Student getStudentById(Long studentId);

    Student updateStudent(Student student);


    void deleteStudentById(Long studentId);


    List<Student> findStudentByName(String searchString);
}
