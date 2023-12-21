package com.example.mentorsystembackend.controller;

import com.example.mentorsystembackend.model.Student_Leave;
import com.example.mentorsystembackend.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/Student_leave")
public class StudentLeaveController {
    @Autowired
    private StudentLeaveService studentLeaveService;
    @PostMapping("/add")
    public String add(@RequestBody Student_Leave student_leave){
        studentLeaveService.saveStudent_Leave(student_leave);
        return "Student Leave Saved";
    }
    @GetMapping("{id}")
    public ResponseEntity<Student_Leave> getStudent_LeaveById(@PathVariable("id") long id){
        return new ResponseEntity<Student_Leave>(studentLeaveService.getStudent_LeaveById(id), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public List<Student_Leave> getAllStudent_Leave(){
        return studentLeaveService.getAllStudent_Leave();}

    @GetMapping("{leave_id}")
    public ResponseEntity<Student_Leave> UpdateStudent_leave(@PathVariable("id") long id, @RequestBody Student_Leave student_leave){
        return new ResponseEntity<Student_Leave>(studentLeaveService.updateStudent_Leave(student_leave, id), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent_Leave(@PathVariable("id") long id){
        studentLeaveService.deleteStudent_Leave(id);

        return new ResponseEntity<String>("Student_Leave deleted", HttpStatus.OK);
    }



}
