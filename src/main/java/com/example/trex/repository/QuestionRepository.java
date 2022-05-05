package com.example.trex.repository;



import com.example.trex.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Override
   Optional<Question> findById(Long id);


    List<Question> findByExamId(Long idSubject);

}
