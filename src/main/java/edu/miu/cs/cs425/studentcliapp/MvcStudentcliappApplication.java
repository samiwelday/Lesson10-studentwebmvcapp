package edu.miu.cs.cs425.studentcliapp;

import edu.miu.cs.cs425.studentcliapp.model.Classroom;
import edu.miu.cs.cs425.studentcliapp.model.Course;
import edu.miu.cs.cs425.studentcliapp.model.Student;
import edu.miu.cs.cs425.studentcliapp.model.Transcript;
import edu.miu.cs.cs425.studentcliapp.service.ClassroomService;
import edu.miu.cs.cs425.studentcliapp.service.StudentService;
import edu.miu.cs.cs425.studentcliapp.service.TranscriptService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MvcStudentcliappApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private ClassroomService classroomService;

    public static void main(String[] args) {
        SpringApplication.run(MvcStudentcliappApplication.class, args);
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, Spring Boot!");
/*
         //Creating new Transcript Object
        Transcript transcript1 = new Transcript(null,"BS Computer Science",null);
        Transcript transcript2 = new Transcript(null,"BS Mining Engineering",null);
        Transcript transcript3 = new Transcript(null,"MS Computer Science",null);
        Transcript transcript4 = new Transcript(null,"MS Chemical Engineering",null);
        Transcript transcript5 = new Transcript(null,"MS Ground Water Resource Management",null);

        // Creating new Classroom Object
        var classroom1 = new Classroom(null,"McLaughlin","M105",null);
        var classroom2 = new Classroom(null,"Verill","V47",null);

        // Creating new Course Object Course {1, "CS401", "Modern Prog Practices}
        var course1 = new Course(null,"CS401","Modern Prog Practices",null);
        var course2 = new Course(null,"CS425","Software Engineering",null);
        var course3 = new Course(null,"CS472","Data Mining",null);


        // Creating new Student Object with its Transcript, Course and Classroom
        Student student1 = new Student(null,"000-61-0001","Anna","Lynn","Smith",3.45, LocalDate.of(2019,5,24),transcript1,classroom1,List.of(course1,course2,course3));
        Student student2 = new Student(null,"000-61-0002","Mnna","Kynn","Wmith",3.00, LocalDate.of(2018,8,28),transcript2,classroom2,List.of(course1,course2,course3));
        Student student3 = new Student(null,"000-61-0003","Fnna","Vynn","Qmith",2.95, LocalDate.of(2017,6,18),transcript3,classroom2,List.of(course1,course2,course3));
        Student student4 = new Student(null,"000-61-0004","Salem","Kiros","Tsegay",3.99, LocalDate.of(2018,9,27),transcript4,classroom1,List.of(course1,course2,course3));
        Student student5 = new Student(null,"000-61-0005","Samuel","Welday","Weldemichael",2.95, LocalDate.of(2017,6,18),transcript5,classroom1,List.of(course1,course2,course3));

        // Save Student Object(Persist)
        Student student1save = saveStudent(student1);
        Student student2save = saveStudent(student2);
        Student student3save = saveStudent(student3);
        Student student4save = saveStudent(student4);
        Student student5save = saveStudent(student5);
*/

        System.out.println("Student Management App Ended ...");

    }

    private Student saveStudent(Student student){
        return studentService.addNewStudent(student);
    }
    private Transcript saveTranscript(Transcript transcript){
        return transcriptService.saveTranscript(transcript);
    }

    private Classroom saveClassroom(Classroom classroom){return classroomService.addClassroom(classroom);}

    }

