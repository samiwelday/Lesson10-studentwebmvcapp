package edu.miu.cs.cs425.studentcliapp.controller;

import edu.miu.cs.cs425.studentcliapp.model.Student;
import edu.miu.cs.cs425.studentcliapp.model.Transcript;
import edu.miu.cs.cs425.studentcliapp.repository.StudentRepository;
import edu.miu.cs.cs425.studentcliapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/sysadmin/student"})
public class StudentController {
    private StudentRepository studentRepository;
    private StudentService studentService;
    public StudentController(StudentService studentService,StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

// Get all list of students
    @GetMapping(value = {"/list"})
    public String listStudents(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "sysadmin/student/list";
    }
    // Second way of doing it
//    @GetMapping(value = {"/list2"})
//    public ModelAndView listStudent2() {
//        var students = studentService.getAllStudentsSorted();
//        var modelAndView = new ModelAndView();
//        modelAndView.addObject("students", students);
//        modelAndView.setViewName("sysadmin/student/list");
//        return modelAndView;
//    }

    @GetMapping(value = "/new")
    public String displayNewStudentForm(Model model) {
        //var transcript = new Transcript();
        var student = new Student();
        //student.setTranscript(transcript);
        model.addAttribute("student", student);
        return "sysadmin/student/new";
    }

    @PostMapping(value = "/new")
    public String addNewStudent(@Valid @ModelAttribute("student") Student newStudent,
          BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "sysadmin/student/new";
        }
        studentService.addNewStudent(newStudent);
        return "redirect:/sysadmin/student/list2";
    }

// Edit Student
    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "sysadmin/student/update";
        }
        return "redirect:/sysadmin/student/list";
    }

// Update Student
    @PostMapping(value = {"/update/{studentId}"})
    public String updateStudent(@Valid @ModelAttribute("studentId") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "sysadmin/student/update";
        }
        studentService.updateStudent(student);
        return "redirect:/sysadmin/student/list";
    }

// Search Student
    @GetMapping(value = {"/searchview"})
    public String displaySearch(){
        return "sysadmin/student/search";
    }


    @GetMapping(value = {"/search"})
    public ModelAndView searchStudent(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var students = studentService.findStudentByName(searchString);
        modelAndView.addObject("student", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("sysadmin/student/search");
        return modelAndView;
    }

//Delete Student
    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/sysadmin/student/list";
    }



}
