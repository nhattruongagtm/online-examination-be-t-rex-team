package com.example.trex.controllers;

import com.example.trex.model.ExamHistory;
import com.example.trex.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExamHistoryController {

    private static final String EXAMS_BY_STUDENT_URL = "/examHistory/{studentId}";

    @Autowired
    private ExamHistoryService examHistoryService;

    @GetMapping(value = "/examHistory/{subjectId}/{studentId}")
    public ResponseEntity<List<ExamHistory>> getExamHistorys(@PathVariable(value = "subjectId") Long subjectId,
                                                             @PathVariable(value = "studentId") Long studentId){
        List<ExamHistory> result;
        result = examHistoryService.getExamHistory(subjectId, studentId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = EXAMS_BY_STUDENT_URL)
    public ResponseEntity<?> getExamsHistory(@PathVariable(value = "studentId") Long studentId){
        List<ExamHistory> result;
        try{
            result = examHistoryService.getExamHistoryByStudent(studentId);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
