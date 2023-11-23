package com.nye.springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nye.springboot.exception.NoFreeSpaceException;
import com.nye.springboot.model.StudentReg;
import com.nye.springboot.services.StudentsService;

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
    public ResponseEntity<String> AddRegistration(@PathVariable Long examId, @RequestBody StudentReg studentReg) {
        try {
            String result = studentService.newRegistration(examId, studentReg);
            return ResponseEntity.ok(result);
        } catch (NoFreeSpaceException e) {
            throw e;
        }
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
 
}
