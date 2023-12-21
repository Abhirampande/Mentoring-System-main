package com.example.mentorsystembackend.service;

import com.example.mentorsystembackend.exception.ResourceNotFoundException;
import com.example.mentorsystembackend.model.Student_Fees;
import com.example.mentorsystembackend.repository.StudentFeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class StudentFeesServiceImpl implements StudentFeesService{

    @Autowired
    private StudentFeesRepository studentFeesRepository;

    @Override
    public Student_Fees saveStudent_Fees(Student_Fees student_fees) {
        return studentFeesRepository.save(student_fees);
    }

    @Override
    public List<Student_Fees> getAllStudent_Fees() {
        return studentFeesRepository.findAll();
    }

    @Override
    public Student_Fees updateStudent_Fees(Student_Fees student_fees, long id) {
        //we need to check whether student_Fee with given id is existed in db or not
        Student_Fees existingStudent_fees = studentFeesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student_Fees", "Id", id));
        existingStudent_fees.setStudent_name(student_fees.getStudent_name() );
        existingStudent_fees.setAmount(student_fees.getAmount());
        existingStudent_fees.setDeposited_at(student_fees.getDeposited_at());
        existingStudent_fees.setDescription(student_fees.getDescription());
        existingStudent_fees.setNote(student_fees.getNote());
        //save existing student_fees to DB
        studentFeesRepository.save(existingStudent_fees);
        return existingStudent_fees;
    }

    @Override
    public void deleteStudent_Fees(long id) {
        //check whether a student exists in db or not
        studentFeesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student_fees", "Id", id));
        studentFeesRepository.deleteById(id);

    }

    @Override
    public Student_Fees getStudent_FeesById(long id) {
        Optional<Student_Fees> student_fees = studentFeesRepository.findById(id);
        if(student_fees.isPresent()){
            return student_fees.get();

        }else {
            throw new ResourceNotFoundException("Student_fees", "Id",id);
        }





    }
}


