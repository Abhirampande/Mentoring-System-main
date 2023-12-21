package com.example.mentorsystembackend.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "contact_number")
    private int contactNumber;

    public Student(){

    }

    public Student(String firstName,String lastName,String emailId, Integer contact_Number){
        super();
        this.firstName = firstName;
        this.lastName  = lastName;
        this.emailId = emailId;
        this.contactNumber = contact_Number;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String email) {
        this.emailId = email;
    }

    public int getContact_Number() {
        return contactNumber;
    }

    public void setContact_Number(int contact_Number) {
        this.contactNumber = contact_Number;
    }
}
