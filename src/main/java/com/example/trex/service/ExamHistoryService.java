package com.example.trex.service;

import com.example.trex.model.ExamHistory;

import java.util.List;

public interface ExamHistoryService {

    List<ExamHistory> getExamHistory(Long subjectId, Long studentId);
    List<ExamHistory> getExamHistoryByStudent(Long studentId);
}
