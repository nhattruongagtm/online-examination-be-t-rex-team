package com.example.trex.controllers;


import com.example.trex.dto.AnswerRequest;
import com.example.trex.dto.QuestionRequest;
import com.example.trex.model.*;
import com.example.trex.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/exam/answers")
    public ResponseEntity<ExamHistory> getCorrectly(@RequestBody AnswerRequest answerRequest){

        //dummy data
        ExamHistory his = new ExamHistory();
        his.setId(1l);
        his.setCorrect(5);
        his.setTotal(10);
        his.setSubject(new Subject());
        his.setStudent(new Student());

//        return ResponseEntity.ok(his);
        return ResponseEntity.ok(questionService.getCorrect(answerRequest));
    }

    @PostMapping(value = "/exam/question")
    public ResponseEntity<String> getListQuestion(@RequestBody QuestionRequest questionRequest) {
            questionService.saveListQuestion(questionRequest);
        return ResponseEntity.ok("ok");

    }


    //load answers of question
    @PostMapping("exam/question/doing")
    public List<Question> getListAnswer(@RequestBody String idSubject_idStudent){
       String[] arrID = idSubject_idStudent.split("_");
       Long idSubject = Long.valueOf(arrID[0]);
        Long idStudent = Long.valueOf(arrID[1]);


        return questionService.getListQuestion(idSubject,idStudent);
    }

    }
