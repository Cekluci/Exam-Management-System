package com.nye.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nye.springboot.model.StudentReg;

@Repository
public interface StudentRegRepository extends JpaRepository<StudentReg, Long> {

/*     @Query("SELECT COUNT(registeredTo) FROM studentRegistration")
    Integer countRegistrations(); */
    
}