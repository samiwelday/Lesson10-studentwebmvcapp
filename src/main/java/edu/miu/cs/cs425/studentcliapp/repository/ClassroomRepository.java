package edu.miu.cs.cs425.studentcliapp.repository;


import edu.miu.cs.cs425.studentcliapp.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
