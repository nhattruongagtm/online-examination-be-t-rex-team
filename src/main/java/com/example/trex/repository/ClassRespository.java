package com.example.trex.repository;

import java.util.List;

import com.example.trex.model.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRespository extends CrudRepository<Classes, Long> {

    List<Classes> findByStudentId(Long studentId);
}
