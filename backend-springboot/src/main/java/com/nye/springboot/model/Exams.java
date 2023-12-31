package com.nye.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "examlistview")
public class Exams {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name="examname")
    private String examName;

    @Column(name="examlocation")
    private String examLocation;

    @Column(name="lecturer")
    private String lecturer;

    @Column(name="examdate")
    private LocalDate examDate;

    @Column(name="examlimit")
    private int examLimit;

    @Column(name="examfreespace")
    private int examFreeSpace;


    public Exams() {

    }


    public Exams(Long Id, String examName, String examLocation, String lecturer, LocalDate examDate, int examLimit, int examFreeSpace) {
        this.Id = Id;
        this.examName = examName;
        this.examLocation = examLocation;
        this.lecturer = lecturer;
        this.examDate = examDate;
        this.examLimit = examLimit;
        this.examFreeSpace = examFreeSpace;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public int getExamLimit() {
        return examLimit;
    }

    public void setExamLimit(int examLimit) {
        this.examLimit = examLimit;
    }

    public int getExamFreeSpace() {
        return examFreeSpace;
    }

    public void setExamFreeSpace(int examFreeSpace) {
        this.examFreeSpace = examFreeSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exams exams = (Exams) o;
        return Objects.equals(Id, exams.Id) && Objects.equals(examName, exams.examName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, examName);
    }

}
