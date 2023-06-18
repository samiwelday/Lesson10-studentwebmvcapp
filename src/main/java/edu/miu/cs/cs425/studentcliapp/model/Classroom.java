package edu.miu.cs.cs425.studentcliapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNumber;
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

}
