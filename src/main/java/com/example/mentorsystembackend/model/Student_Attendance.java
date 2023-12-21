package com.example.mentorsystembackend.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student_attendance")
public class Student_Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_name")
    private String student_name;
    @Column(name = "reg_no")
    private String reg_no;
    @Column(name = "attendance")
    private float attendance;


    public Student_Attendance() {

    }

    public Student_Attendance(String student_name, String reg_no, float attendance) {
        super();
        this.student_name = student_name;
        this.reg_no = reg_no;
        this.attendance = attendance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }
}
