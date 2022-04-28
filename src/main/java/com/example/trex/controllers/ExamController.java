package com.example.trex.controllers;

import com.example.trex.model.Exam;
import com.example.trex.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/checkTest/{studentId}")
    public boolean checkTestPermission(@PathVariable Long studentId, @RequestBody Exam exam ){
        return examService.checkTestPermission(studentId,exam);
    }

    @GetMapping("/exam/{id}")
    public Exam getExam(@PathVariable(name = "id") Long id){
        return examService.getExam(id);
    }
}
