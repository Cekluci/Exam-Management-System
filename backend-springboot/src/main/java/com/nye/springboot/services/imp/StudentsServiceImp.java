package com.nye.springboot.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nye.springboot.exception.NoFreeSpaceException;
import com.nye.springboot.model.Exams;
import com.nye.springboot.model.StudentReg;
import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.StudentRegRepository;
import com.nye.springboot.services.StudentsService;

@Service
public class StudentsServiceImp implements StudentsService {

    StudentRegRepository studentRepository;
    ExamRepository examRepository;

    public StudentsServiceImp(StudentRegRepository studentRepository, ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }


    @Override
    public List<StudentReg> getAllRegistrations() {
        return studentRepository.findAll();
    }

    @Override
    public String newRegistration(Long examId, StudentReg reg) {
        int freeSpace = this.getFreeSpace(examId);
        if (freeSpace > 0) {
            studentRepository.save(reg);
            return "Exam registration was successful.";
        } else {
            throw new NoFreeSpaceException();
        }
    }

    @Override
    public String deleteRegistration(Long Id) {
        studentRepository.findById(Id).ifPresent(reg -> studentRepository.delete(reg));
        return "Success.";
    }

    @Override
    public Long getCountByExamId(Long Id) {
        return studentRepository.countExamIds(Id);
        
    }


    @Override
    public int getFreeSpace(Long Id) {
        Exams exam = examRepository.findById(Id).get();
        return exam.getExamFreeSpace();
    }
    
}
