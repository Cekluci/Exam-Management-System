package com.nye.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.DTO.ExamList.ExamList;
import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;
import com.nye.springboot.services.ExamsService;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class ExamsController {

    //private final CustomServices examService;
    
    private ExamsService examsService;
    
    public ExamsController(ExamsService examsService) {
        this.examsService = examsService;
    }
    
    //Get All Exams
    @GetMapping("/exams")
    public List<Exams> getAllExams() {
        return examsService.getAllExams();
    }

    //Add Exam
    @PostMapping("/exams")
    public String AddExam(@RequestBody ExamsTable exam) {
        examsService.createExam(exam);
        return "Exam created successfully";
    }

    //Get Exam by ID
    @GetMapping("/exams/{id}")
    public ExamsTable getExamById(@PathVariable Long id) {
        return examsService.getExamById(id);
    }

    @PutMapping("/exams/{id}")
    public String updateExam(@PathVariable Long id, @RequestBody ExamsTable exam) {
        examsService.updateExam(id, exam);
        return "Exam updated successfully.";
    }

    @DeleteMapping("/exams/{id}")
    public String deleteExam(@PathVariable Long id) {
        examsService.deleteExam(id);
        return "Exam deleted successfully.";
    }

    //Get the distinct exam list
    @GetMapping("/exams/examList")
    public List<ExamList> getDistinctExams() {
        return examsService.getDistinctExams();
    }
}
