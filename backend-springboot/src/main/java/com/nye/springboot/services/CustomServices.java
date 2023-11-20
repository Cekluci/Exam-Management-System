package com.nye.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.repository.StudentRegRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomServices {
    
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRegRepository studentRepository;

/*     @Transactional
    public Integer calculateFreeSpace(Long examTableId) {
        Integer studentTableCount = 
    } */
}
