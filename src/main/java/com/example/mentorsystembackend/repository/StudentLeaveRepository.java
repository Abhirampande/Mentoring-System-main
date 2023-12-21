package com.example.mentorsystembackend.repository;

import com.example.mentorsystembackend.model.Student_Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLeaveRepository extends JpaRepository<Student_Leave, Long> {
}
