package com.example.trex.service;

import com.example.trex.dto.AnswerRequest;
import com.example.trex.model.ExamHistory;

public interface QuestionService {

    public ExamHistory getCorrect(AnswerRequest request);
}
