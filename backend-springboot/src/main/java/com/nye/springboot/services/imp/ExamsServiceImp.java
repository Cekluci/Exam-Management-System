package com.nye.springboot.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nye.springboot.DTO.ExamList.ExamList;
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

    @Override
    public ExamsTable getExamById(Long Id) {
        return examTableRepository.findById(Id).get();
    }

    @Override
    public String updateExam(Long Id, ExamsTable examDetails) {
        ExamsTable exam = examTableRepository.findById(Id).get();
        exam.setExamName(examDetails.getExamName());
        exam.setExamLocation(examDetails.getExamLocation());
        exam.setLecturer(examDetails.getLecturer());
        exam.setExamDate(examDetails.getExamDate());
        exam.setExamLimit(examDetails.getExamLimit());
        exam.setExamFreeSpace(examDetails.getExamFreeSpace());

        examTableRepository.save(exam);
        return "Success.";
    }

    @Override
    public String deleteExam(Long Id) {
        //ExamsTable exam = examTableRepository.findById(Id).get();
        examTableRepository.findById(Id).ifPresent(exam -> examTableRepository.delete(exam));
        //examTableRepository.delete(exam);
        return "Success.";
    }

    @Override
    public List<ExamList> getDistinctExams() {
        return examRepository.findDistinctExams(); 
    }
    
}
