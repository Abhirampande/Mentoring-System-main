package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.exception.ResourceNotFoundException;
import com.example.mentorsystembackend.model.Student_Attendance;
import com.example.mentorsystembackend.repository.Student_AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {



    @Autowired
    private Student_AttendanceRepository studentAttendanceRepository;

    public StudentAttendanceServiceImpl(Student_AttendanceRepository studentAttendanceRepository) {
        super();
        this.studentAttendanceRepository = studentAttendanceRepository;
    }

    @Override
    public Student_Attendance saveStudent_Attendance(Student_Attendance student_attendance) {
        return studentAttendanceRepository.save(student_attendance);
    }

    @Override
    public List<Student_Attendance> getAllStudent_Attendance() {
        return studentAttendanceRepository.findAll();
    }

    @Override
    public Student_Attendance updateStudentAttendance(Student_Attendance student_attendance, long id) {
        Student_Attendance existingStudent_attendance = studentAttendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student_Attendance", "Id", id));
        existingStudent_attendance.setStudent_name(student_attendance.getStudent_name() );
        existingStudent_attendance.setReg_no(student_attendance.getReg_no());

        //save existing student_fees to DB
        studentAttendanceRepository.save(existingStudent_attendance);
        return existingStudent_attendance;
    }

    @Override
     public void deleteStudent_Attendance(long id){
   studentAttendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student_attendance","Id",id));
   studentAttendanceRepository.deleteById(id);

    }

    public Student_Attendance getStudent_AttendanceById(long id){
        Optional<Student_Attendance> student_attendance = studentAttendanceRepository.findById(id);
        if (student_attendance.isPresent()){
            return student_attendance.get();


            }else{
            throw new ResourceNotFoundException("Student_attendance", "Id", id);
        }
    }
}




