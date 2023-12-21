package com.example.mentorsystembackend.controller;

import com.example.mentorsystembackend.model.Student_Attendance;
import com.example.mentorsystembackend.model.Student_Fees;
import com.example.mentorsystembackend.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/v1/Student_attendance")
public class StudentAttendanceController {


    private StudentAttendanceService studentAttendanceService;

    public StudentAttendanceController(StudentAttendanceService studentAttendanceService) {
        super();
        this.studentAttendanceService = studentAttendanceService;
    }

    @PostMapping("add")
    public String add(@RequestBody Student_Attendance student_attendance) {
        studentAttendanceService.saveStudent_Attendance(student_attendance);
        return "Student Attendance";
    }

    @GetMapping("/getAllAttendance")
    public List<Student_Attendance> getAllStudent_Attendance() {
        return studentAttendanceService.getAllStudent_Attendance();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student_Attendance> getStudent_AttendanceById(@PathVariable("id") long id) {
        return new ResponseEntity<Student_Attendance>(studentAttendanceService.getStudent_AttendanceById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student_Attendance> UpdateStudent_Attendance(@PathVariable("id") long id
            , @RequestBody Student_Attendance student_attendance) {
        return new ResponseEntity<Student_Attendance>(studentAttendanceService.updateStudentAttendance(student_attendance, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent_Attendance(@PathVariable("id") long id) {
        studentAttendanceService.deleteStudent_Attendance(id);

        return new ResponseEntity<String>("Student_Fees deleted successfully", HttpStatus.OK);

    }
}



