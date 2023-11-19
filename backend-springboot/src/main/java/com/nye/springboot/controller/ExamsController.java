package com.nye.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.model.Exams;
import com.nye.springboot.repository.ExamRepository;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class ExamsController {
    
    @Autowired
    private ExamRepository examRepository;
    
    //Get All Exams
    @GetMapping("/exams")
    public List<Exams> getAllExams() {
        return examRepository.findAll();
    }

    //Add Exam
    @PostMapping("/exams")
    public Exams AddExam(@RequestBody Exams exam) {
        return examRepository.save(exam);
    }
}
