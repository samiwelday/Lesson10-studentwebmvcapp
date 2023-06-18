package edu.miu.cs.cs425.studentcliapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Student number is required and it shouldn't be Empty, Null or Blank")
    private String studentNumber;;
    @Column(nullable = false)
    @NotBlank(message = "First name is required and it shouldn't be Empty, Null or Blank")
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    @NotBlank(message = "Last name is required")
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_id", referencedColumnName = "transcriptId",unique = true)
    private Transcript transcript;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_Id",referencedColumnName = "classroomId")
    private Classroom classroom;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
    private List<Course> courses;


}
