package com.example.mentorsystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mentorsystembackend.model.Student;
@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
}
