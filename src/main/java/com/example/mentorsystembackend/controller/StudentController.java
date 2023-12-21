package com.example.mentorsystembackend.controller;

import com.example.mentorsystembackend.exception.ResourceNotFoundException;
import com.example.mentorsystembackend.model.Mentor;
import com.example.mentorsystembackend.model.Student;
import com.example.mentorsystembackend.repository.MentorRepository;
import com.example.mentorsystembackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
// get all students
    @GetMapping(path = "/student")
    public List<Student> getAllStudent(){
       return studentRepository.findAll();
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("student not exits with id :" + id, "Id", id));
        return ResponseEntity.ok(student);
    }
    @PostMapping("/student/insert")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id, "Id", id));
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setContact_Number(studentDetails.getContact_Number());
        student.setEmailId(studentDetails.getEmailId());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id, "Id", id));
        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }









}
