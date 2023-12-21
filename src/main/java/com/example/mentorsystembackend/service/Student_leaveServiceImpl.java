package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.exception.ResourceNotFoundException;
import com.example.mentorsystembackend.model.Student_Leave;
import com.example.mentorsystembackend.repository.StudentLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Student_leaveServiceImpl implements StudentLeaveService {

    @Autowired
    private StudentLeaveRepository studentLeaveRepository;

    @Override
    public Student_Leave saveStudent_Leave(Student_Leave student_leave) {
        return studentLeaveRepository.save(student_leave);
    }

    @Override
    public List<Student_Leave> getAllStudent_Leave() {
        return studentLeaveRepository.findAll();
    }

    @Override
    public Student_Leave getStudent_LeaveById(long id) {
        Optional<Student_Leave> student_leave = studentLeaveRepository.findById(id);
        if (student_leave.isPresent()) {
            return student_leave.get();


        } else {
            throw new ResourceNotFoundException("Student_leave", "Id", id);
        }


    }

    @Override
    public Student_Leave updateStudent_Leave(Student_Leave student_leave, long id) {
        Student_Leave exitingStudent_leave = studentLeaveRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Student_leave", "Id",id));
        exitingStudent_leave.setFirstname(student_leave.getFirstname());
        exitingStudent_leave.setLastname(student_leave.getLastname());
        exitingStudent_leave.setEmail(student_leave.getEmail());
        exitingStudent_leave.setReg_no(student_leave.getReg_no());
        exitingStudent_leave.setFrom_date(student_leave.getFrom_date());
        exitingStudent_leave.setTill_date(student_leave.getTill_date());

        studentLeaveRepository.save(exitingStudent_leave);
        return exitingStudent_leave;
    }

    @Override
    public void deleteStudent_Leave(long id) {
        studentLeaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student_leave", "Id", id));
        studentLeaveRepository.deleteById(id);


    }

}
