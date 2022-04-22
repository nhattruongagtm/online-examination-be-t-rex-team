package com.example.trex.repository;

import java.util.List;

import com.example.trex.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.trex.model.Subject;

@Repository
public interface ClassesRespository extends CrudRepository<Classes, Long> {

    List<Classes> findByStudentId(Long studentId);
}
