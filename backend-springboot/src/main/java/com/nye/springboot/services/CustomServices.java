package com.nye.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.StudentRegRepository;
import com.nye.springboot.DTO.ExamList.ExamList;

import jakarta.transaction.Transactional;

@Service
public class CustomServices {

    private final ExamRepository examRepository;
    
    @Autowired
    public CustomServices(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }


/*     @Transactional
    public Integer calculateFreeSpace(Long examTableId) {
        Integer studentTableCount = 
    } */

    public List<ExamList> getDistinctExams() {
        return examRepository.findDistinctExams();
    }
}
