package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.model.Student_Fees;

import java.util.List;

public interface StudentFeesService {
    public Student_Fees saveStudent_Fees(Student_Fees student_fees);
    public List<Student_Fees> getAllStudent_Fees();

    public Student_Fees getStudent_FeesById(long id);
    public Student_Fees updateStudent_Fees(Student_Fees student_fees, long id);
    void deleteStudent_Fees(long id);







}
