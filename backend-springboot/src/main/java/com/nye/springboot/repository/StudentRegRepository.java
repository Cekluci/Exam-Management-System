package com.nye.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nye.springboot.model.StudentReg;

@Repository
public interface StudentRegRepository extends JpaRepository<StudentReg, Long> {

}