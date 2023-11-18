package com.nye.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nye.springboot.model.Exams;

@Repository
public interface ExamRepository extends JpaRepository<Exams, Long> {

    
}