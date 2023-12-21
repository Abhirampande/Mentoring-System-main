package com.example.mentorsystembackend.controller;

import com.example.mentorsystembackend.model.Student_Fees;
import com.example.mentorsystembackend.service.StudentFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/Student_fees")
public class StudentFeesController {
    @Autowired
    private StudentFeesService studentFeesService;
    @PostMapping("/add")
    public String add(@RequestBody Student_Fees student_fees){
        studentFeesService.saveStudent_Fees(student_fees);
        return "Student Fees Added";
    }
    @GetMapping("/getAll")
    public List<Student_Fees> getAllStudent_Fees(){
        return studentFeesService.getAllStudent_Fees();
    }
    //localhost:8081/api/v1/Student_fees/1
    @GetMapping("{id}")
    public ResponseEntity<Student_Fees> getStudent_FeesById(@PathVariable("id") long id){
        return new ResponseEntity<Student_Fees>(studentFeesService.getStudent_FeesById(id), HttpStatus.OK);

    }
    //building update employee api
    @PutMapping("{id}")
    public ResponseEntity<Student_Fees> UpdateStudent_fees(@PathVariable("id") long id
                                                            ,@RequestBody Student_Fees student_fees){
        return new ResponseEntity<Student_Fees>(studentFeesService.updateStudent_Fees(student_fees ,id), HttpStatus.OK);


    }
    //delete student_fees
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent_Fees(@PathVariable("id") long id){
        studentFeesService.deleteStudent_Fees(id);

        return new ResponseEntity<String>("Student_Fees deleted successfully", HttpStatus.OK);

    }



    }






