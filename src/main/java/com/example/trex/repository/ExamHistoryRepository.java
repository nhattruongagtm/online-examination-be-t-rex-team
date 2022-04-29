package com.example.trex.repository;

import com.example.trex.model.ExamHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamHistoryRepository extends JpaRepository<ExamHistory, Long> {

    List<ExamHistory> findBySubjectIdAndStudentId(Long subjectId, Long studentId);

    List<ExamHistory> findByStudentId(Long studentId);

    @Override
    <S extends ExamHistory> S save(S entity);
}
