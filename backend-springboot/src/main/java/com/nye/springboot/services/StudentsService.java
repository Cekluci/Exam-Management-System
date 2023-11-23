package com.nye.springboot.services;

import java.util.List;

import com.nye.springboot.model.StudentReg;

public interface StudentsService {
    
    public List<StudentReg> getAllRegistrations();

    public String newRegistration(Long examId, StudentReg reg);

    public String deleteRegistration(Long Id);

    public Long getCountByExamId(Long Id);

    public int getFreeSpace(Long Id);
}
