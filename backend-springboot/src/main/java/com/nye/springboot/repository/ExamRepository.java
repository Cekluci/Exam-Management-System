package com.nye.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nye.springboot.DTO.ExamList.ExamList;
import com.nye.springboot.model.Exams;

@Repository
public interface ExamRepository extends JpaRepository<Exams, Long> {

    @Query("SELECT new com.nye.springboot.DTO.ExamList.ExamList(e.Id, e.examName) FROM Exams e")
    List<ExamList> findDistinctExams();
    
}