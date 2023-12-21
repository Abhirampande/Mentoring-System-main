package com.example.mentorsystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.mentorsystembackend.model.Mentor;
@Repository
public interface MentorRepository  extends JpaRepository<Mentor, Long> {
}
