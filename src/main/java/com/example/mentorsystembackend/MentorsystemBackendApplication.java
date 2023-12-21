package com.example.mentorsystembackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MentorsystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentorsystemBackendApplication.class, args);
    }

}
