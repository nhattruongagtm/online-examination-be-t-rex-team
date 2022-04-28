package com.example.trex.service;

import com.example.trex.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ExamService {

    boolean checkTestPermission(Long id, Exam exam);

    Exam getExam(Long id);

}
