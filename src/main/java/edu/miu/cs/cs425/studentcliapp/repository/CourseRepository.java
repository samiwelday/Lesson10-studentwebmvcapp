package edu.miu.cs.cs425.studentcliapp.repository;


import edu.miu.cs.cs425.studentcliapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
