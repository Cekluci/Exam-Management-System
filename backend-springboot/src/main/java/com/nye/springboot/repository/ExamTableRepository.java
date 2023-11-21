package com.nye.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nye.springboot.model.ExamsTable;


@Repository
public interface ExamTableRepository extends JpaRepository<ExamsTable, Long> {

}