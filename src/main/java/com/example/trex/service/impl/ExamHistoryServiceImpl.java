package com.example.trex.service.impl;

import com.example.trex.model.ExamHistory;
import com.example.trex.repository.ExamHistoryRepository;
import com.example.trex.service.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService {

    @Autowired
    private ExamHistoryRepository examHistoryRepository;

    @Override
    public List<ExamHistory> getExamHistory(Long subjectId, Long studentId) {
        return examHistoryRepository.findBySubjectIdAndStudentId(subjectId, studentId);
    }

    /**
     *
     * @param studentId
     * @return
     */
    @Override
    public List<ExamHistory> getExamHistoryByStudent(Long studentId) {
        return examHistoryRepository.findByStudentId(studentId);
    }
}
