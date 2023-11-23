package com.nye.springboot.services;

import java.util.List;

import com.nye.springboot.DTO.ExamList.ExamList;
import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;

public interface ExamsService {
    
    public List<Exams> getAllExams();

    public String createExam(ExamsTable exam);
    
    public ExamsTable getExamById(Long Id);

    public String updateExam(Long Id, ExamsTable examDetails);

    public String deleteExam(Long Id);

    public List<ExamList> getDistinctExams();

}
