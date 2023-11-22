package com.nye.springboot.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;
import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.ExamTableRepository;
import com.nye.springboot.services.ExamsService;

@Service
public class ExamsServiceImp implements ExamsService {

    ExamTableRepository examTableRepository;
    ExamRepository examRepository;

    public ExamsServiceImp(ExamRepository examRepository, ExamTableRepository examTableRepository) {
        this.examRepository = examRepository;
        this.examTableRepository = examTableRepository;
    }

    @Override
    public List<Exams> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public String createExam(ExamsTable exam) {
        examTableRepository.save(exam);
        return "Success.";
    }
    
}
