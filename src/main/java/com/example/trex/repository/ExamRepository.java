package com.example.trex.repository;

import com.example.trex.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findExamByIdAndDate(Long id, Date date);
    Exam findExamById(Long id);
    List<Exam> findByUserId(Long id);
    List<Exam> findExamByDateAndSubjectId(String date,Long code);
}
