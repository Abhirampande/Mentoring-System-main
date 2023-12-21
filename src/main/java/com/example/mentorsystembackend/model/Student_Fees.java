package com.example.mentorsystembackend.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="student_fees")
public class Student_Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name")
    private String student_name;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "deposited_at")
    private BigDecimal deposited_at;
    @Column(name = "description")
    private String description;
    @Column(name = "note")
    private String note;

    public Student_Fees() {
    }

    public Student_Fees(String student_name, BigDecimal amount, Long deposited_at, String description, String note) {
        super();
        this.student_name = student_name;
        this.amount = amount;
        this.deposited_at = BigDecimal.valueOf(deposited_at);
        this.description = description;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDeposited_at() {
        return deposited_at;
    }

    public void setDeposited_at(BigDecimal deposited_at) {
        this.deposited_at = deposited_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
