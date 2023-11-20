package com.nye.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentregistration")
public class StudentReg {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="studentname")
    private String studentName;

    @Column(name="registeredto")
    private String registeredTo;

    @Column(name="examid")
    private Integer examId;


    public StudentReg() {

    }


    public StudentReg(Long Id, String studentName, String registeredTo, Integer examId) {
        this.Id = Id;
        this.studentName = studentName;
        this.registeredTo = registeredTo;
        this.examId = examId;
    }



    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRegisteredTo() {
        return this.registeredTo;
    }

    public void setRegisteredTo(String registeredTo) {
        this.registeredTo = registeredTo;
    }

    public Integer getExamId() {
        return this.examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

}
