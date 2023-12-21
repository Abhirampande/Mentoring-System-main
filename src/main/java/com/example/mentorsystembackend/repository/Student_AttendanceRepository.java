package com.example.mentorsystembackend.repository;

import com.example.mentorsystembackend.model.Student_Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_AttendanceRepository  extends JpaRepository <Student_Attendance, Long> {
}
