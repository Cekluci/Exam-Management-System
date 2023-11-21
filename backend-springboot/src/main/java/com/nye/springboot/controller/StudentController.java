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

import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

/*     private final CustomServices studentService;
    
    @Autowired
    public StudentController(CustomServices studentService) {
        this.studentService = studentService;
    } */

    @Autowired
    private StudentRegRepository studentRepository;

    @Autowired
    private CustomServices customServices;

    //Get All registrations
    @GetMapping("/students")
    public List<StudentReg> getAllRegistrations() {
        return studentRepository.findAll();
    }

    //Register to an exam
    @PostMapping("/students")
    public StudentReg AddRegistration_old(@RequestBody StudentReg studentReg) {
        return studentRepository.save(studentReg);
    }

    //Delete registration
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRegistration(@PathVariable Long id) {
        StudentReg studentReg = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registration not found with this id: " + id));
    
        studentRepository.delete(studentReg);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //Get count
    @GetMapping("/students/{examId}")
    public ResponseEntity<Long> getCountByExamId(@PathVariable Long examId) {
        Long count = studentRepository.countExamIds(examId);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/students/register/{examId}")
    public ResponseEntity<?> AddRegistration(@PathVariable Long examId, @RequestBody StudentReg studentReg) {
        int freeSpace = customServices.getFreeSpace(examId);
        if (freeSpace > 0) {
            studentRepository.save(studentReg);
            return ResponseEntity.ok().body("Exam registration was successful.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Registration failed: No free spaces available.");
        }
    }
    
}
