package edu.miu.cs.cs425.studentcliapp.service.impl;


import edu.miu.cs.cs425.studentcliapp.model.Classroom;
import edu.miu.cs.cs425.studentcliapp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentcliapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public Classroom addClassroom(Classroom newClassroom) {
        return classroomRepository.save(newClassroom);
    }
}
