package com.example.mentorsystembackend.controller;

import com.example.mentorsystembackend.exception.ResourceNotFoundException;
import com.example.mentorsystembackend.model.Mentor;
import com.example.mentorsystembackend.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1/")
public class MentorController {
    @Autowired
    private MentorRepository mentorRepository;
    //get all mentor

    @GetMapping("/mentors")
    public List<Mentor> getAllMentor(){
        return mentorRepository.findAll();
    }
    //get mentor by id
    @GetMapping("/mentor/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable Long id) {



        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("mentor not exits with id :" + id, "Id", id));
        return ResponseEntity.ok(mentor);
    }

    //creating rest api
    @PostMapping("/mentor")
    public Mentor createMentor(@RequestBody Mentor mentor){
        return mentorRepository.save(mentor);
    }
    //update mentor rest api
    @PutMapping("/mentor/put/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Long id, @RequestBody Mentor mentorDetails){
        Mentor mentor = mentorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mentor not exist with id :" + id, "Id", id));
        mentor.setFirstName(mentorDetails.getFirstName());
        mentor.setLastName(mentorDetails.getLastName());
        mentor.setEmailId(mentorDetails.getEmailId());

        Mentor updatedMentor = mentorRepository.save(mentor);
        return ResponseEntity.ok(updatedMentor);

    }

    //Delete mentor api
    @DeleteMapping("/mentor/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMentor(@PathVariable Long id){
    Mentor mentor = mentorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("mentor not exist with id :" + id, "Id", id));
    mentorRepository.delete(mentor);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }
}
