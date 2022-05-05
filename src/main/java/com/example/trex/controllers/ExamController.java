package com.example.trex.controllers;

import com.example.trex.dto.ExamDTO;
import com.example.trex.model.Exam;
import com.example.trex.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/list-exam/{id}")
    public List<Exam> getListExam(@PathVariable(name = "id") Long id){
        return examService.getListExam(id);
    }

    @GetMapping("/exam")
    public Exam loadExam(@RequestParam(name = "code") String code){
        return examService.loadExam(code);
    }
    @GetMapping("/exams/{studentID}")
    public List<ExamDTO> loadExamList(@PathVariable(value = "studentID") Long id){
        return examService.getExamListByStudentID(id);
    }
}
