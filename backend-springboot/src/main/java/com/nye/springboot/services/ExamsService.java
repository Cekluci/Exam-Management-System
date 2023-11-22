package com.nye.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;
import com.nye.springboot.repository.ExamRepository;

public interface ExamsService {
    
    public List<Exams> getAllExams();

    public String createExam(ExamsTable exam);
    



}
