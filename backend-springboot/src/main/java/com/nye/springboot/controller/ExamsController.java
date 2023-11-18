package com.nye.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.model.Exams;
import com.nye.springboot.repository.ExamRepository;

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
}
