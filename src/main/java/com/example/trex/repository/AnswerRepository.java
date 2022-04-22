package com.example.trex.repository;

import com.example.trex.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Override
    List<Answer> findAll();

    List<Answer> findByQuestionId(Long questionId);
}
