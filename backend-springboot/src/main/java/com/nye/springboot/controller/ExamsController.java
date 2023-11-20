package com.nye.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.exception.ResourceNotFoundException;
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

    //Get Exam by ID
    @GetMapping("/exams/{id}")
    public ResponseEntity<Exams> getExamById(@PathVariable Long id) {
        Exams exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));
        return ResponseEntity.ok(exam);
    }

    //Update Exam
    @PutMapping("/exams/{id}")
    public ResponseEntity<Exams> updateExam(@PathVariable Long id, @RequestBody Exams examDetails) {
        Exams exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));
        exam.setExamName(examDetails.getExamName());
        exam.setExamLocation(examDetails.getExamLocation());
        exam.setLecturer(examDetails.getLecturer());
        exam.setExamDate(examDetails.getExamDate());
        exam.setExamLimit(examDetails.getExamLimit());
        exam.setExamFreeSpace(examDetails.getExamFreeSpace());

        Exams updatedExam = examRepository.save(exam);
        return ResponseEntity.ok(updatedExam);
    }
}
