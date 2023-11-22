package com.nye.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.nye.springboot.exception.ResourceNotFoundException;
import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;
import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.ExamTableRepository;
//import com.nye.springboot.services.CustomServices;
import com.nye.springboot.services.ExamsService;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class ExamsController {

    //private final CustomServices examService;
    
    private ExamsService examsService;
    
    @Autowired
    public ExamsController(ExamsService examsService) {
        this.examsService = examsService;
    }
    
/*     @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamTableRepository examTableRepository; */

/*     @Autowired
    public ExamsController(CustomServices examService) {
        this.examService = examService;
    } */
    
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
    //Add Exam
    /* @PostMapping("/exams")
    public ExamsTable AddExam(@RequestBody ExamsTable exam) {
        return examTableRepository.save(exam);
    }

    //Get Exam by ID
    @GetMapping("/exams/{id}")
    public ResponseEntity<Exams> getExamById(@PathVariable Long id) {
        Exams exam = examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));
        return ResponseEntity.ok(exam);
    }

    //Update Exam
    @PutMapping("/exams/{id}")
    public ResponseEntity<ExamsTable> updateExam(@PathVariable Long id, @RequestBody ExamsTable examDetails) {
        ExamsTable exam = examTableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));
        exam.setExamName(examDetails.getExamName());
        exam.setExamLocation(examDetails.getExamLocation());
        exam.setLecturer(examDetails.getLecturer());
        exam.setExamDate(examDetails.getExamDate());
        exam.setExamLimit(examDetails.getExamLimit());
        exam.setExamFreeSpace(examDetails.getExamFreeSpace());

        ExamsTable updatedExam = examTableRepository.save(exam);
        return ResponseEntity.ok(updatedExam);
    }

    //Delete Exam
    @DeleteMapping("/exams/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteExam(@PathVariable Long id) {
        ExamsTable exam = examTableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));

        examTableRepository.delete(exam);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //Get the distinct exam list
    @GetMapping("/exams/examList")
    public ResponseEntity<List<ExamList>> getDistinctExams() {
        List<ExamList> distinctList = examService.getDistinctExams();
        return ResponseEntity.ok(distinctList);
    } */
}
