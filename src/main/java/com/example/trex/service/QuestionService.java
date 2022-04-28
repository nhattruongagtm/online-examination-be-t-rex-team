package com.example.trex.service;

import com.example.trex.dto.AnswerRequest;
import com.example.trex.dto.QuestionRequest;
import com.example.trex.model.ExamHistory;
import com.example.trex.model.Question;

import java.util.List;

public interface QuestionService {

    public ExamHistory getCorrect(AnswerRequest request);

    public void saveListQuestion(QuestionRequest listQuestionRequest);
}
