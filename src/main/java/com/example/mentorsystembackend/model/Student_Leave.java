package com.example.mentorsystembackend.model;

import javax.persistence.*;

    @Entity
    @Table(name = "student_Leave")

    public class Student_Leave {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int reg_no;
        @Column(name ="first_name")
        private String firstname;
        @Column(name = "last_name")
        private String lastname;
        @Column(name = "email")
        private String email;
        @Column(name = "from_date")
        private int from_date;
        @Column(name = "till_date")
        private int till_date;

        public Student_Leave(){

        }

        public Student_Leave(int reg_no, String firstname, String lastname, String email, int from_date, int till_date) {
            super();
            this.reg_no = reg_no;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.from_date = from_date;
            this.till_date = till_date;
        }

        public int getReg_no() {
            return reg_no;
        }

        public void setReg_no(int reg_no) {
            this.reg_no = reg_no;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getFrom_date() {
            return from_date;
        }

        public void setFrom_date(int from_date) {
            this.from_date = from_date;
        }

        public int getTill_date() {
            return till_date;
        }

        public void setTill_date(int till_date) {
            this.till_date = till_date;
        }

        @Override
        public String toString() {
            return "Student_Leave{" +
                    "reg_no=" + reg_no +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", email='" + email + '\'' +
                    ", from_date=" + from_date +
                    ", till_date=" + till_date +
                    '}';
        }
    }

