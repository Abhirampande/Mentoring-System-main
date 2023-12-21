package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.model.Student_Leave;

import java.util.List;

public interface StudentLeaveService {
    public Student_Leave saveStudent_Leave(Student_Leave student_leave);

    public List<Student_Leave> getAllStudent_Leave();

    public Student_Leave getStudent_LeaveById(long id);

    public Student_Leave updateStudent_Leave(Student_Leave student_leave, long id);

    void deleteStudent_Leave(long id);
}
