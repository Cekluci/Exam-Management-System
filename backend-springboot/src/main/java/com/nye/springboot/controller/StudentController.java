package com.nye.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.DTO.ExamList.ExamList;
import com.nye.springboot.exception.ResourceNotFoundException;
import com.nye.springboot.model.StudentReg;
import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.StudentRegRepository;
import com.nye.springboot.services.CustomServices;
import com.nye.springboot.services.StudentsService;

import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    private StudentsService studentService;

    public StudentController (StudentsService studentService) {
        this.studentService = studentService;
    }

/*     @Autowired
    private StudentRegRepository studentRepository;

    @Autowired
    private CustomServices customServices; */

    //Get All registrations
    @GetMapping("/students")
    public List<StudentReg> getAllRegistrations() {
        return studentService.getAllRegistrations();
    }

    //Register to an exam
    @PostMapping("/students/register/{examId}")
    public String AddRegistration(@PathVariable Long examId, @RequestBody StudentReg studentReg) {
        studentService.newRegistration(examId, studentReg);
        return "Registration created successfully.";
    }

    //Delete registration
    @DeleteMapping("/students/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        studentService.deleteRegistration(id);
        return "Exam deleted successfully.";
    }

    //Get count
    @GetMapping("/students/{examId}")
    public Long getCountByExamId(@PathVariable Long examId) {
        return studentService.getCountByExamId(examId);
    }

/*     @PostMapping("/students/register/{examId}")
    public ResponseEntity<?> AddRegistration(@PathVariable Long examId, @RequestBody StudentReg studentReg) {
        int freeSpace = customServices.getFreeSpace(examId);
        if (freeSpace > 0) {
            studentRepository.save(studentReg);
            return ResponseEntity.ok().body("Exam registration was successful.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Registration failed: No free spaces available.");
        }
    } */
    
}
