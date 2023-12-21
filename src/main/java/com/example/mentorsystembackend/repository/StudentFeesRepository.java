package com.example.mentorsystembackend.repository;

import com.example.mentorsystembackend.model.Student_Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFeesRepository extends JpaRepository<Student_Fees, Long> {
}
