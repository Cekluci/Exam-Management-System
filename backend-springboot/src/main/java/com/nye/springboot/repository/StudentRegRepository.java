package com.nye.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nye.springboot.model.StudentReg;

@Repository
public interface StudentRegRepository extends JpaRepository<StudentReg, Long> {

    @Query("SELECT COUNT(t) FROM StudentReg t WHERE t.examId = :examId")
    Long countExamIds(@Param("examId") Long examId);
}