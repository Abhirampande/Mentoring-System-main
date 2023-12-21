package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.model.Student_Attendance;

import java.util.List;

public interface StudentAttendanceService {
    public Student_Attendance saveStudent_Attendance(Student_Attendance student_attendance);

    public List<Student_Attendance> getAllStudent_Attendance();

    public Student_Attendance getStudent_AttendanceById(long id);

    public Student_Attendance updateStudentAttendance(Student_Attendance student_attendance, long id);

    void deleteStudent_Attendance(long id);
}
