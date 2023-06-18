package edu.miu.cs.cs425.studentcliapp.service.impl;


import edu.miu.cs.cs425.studentcliapp.model.Student;
import edu.miu.cs.cs425.studentcliapp.repository.StudentRepository;
import edu.miu.cs.cs425.studentcliapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student newstudent) {

        return studentRepository.save(newstudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsSorted() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);

    }

    @Override
    public List<Student> findStudentByName(String searchString) {
        return studentRepository.findAllStudentByFirstNameContainingIgnoreCase(searchString);
    }


}
