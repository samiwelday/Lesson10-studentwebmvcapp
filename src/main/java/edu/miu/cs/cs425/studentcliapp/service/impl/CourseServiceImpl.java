package edu.miu.cs.cs425.studentcliapp.service.impl;


import edu.miu.cs.cs425.studentcliapp.model.Course;
import edu.miu.cs.cs425.studentcliapp.repository.CourseRepository;
import edu.miu.cs.cs425.studentcliapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
