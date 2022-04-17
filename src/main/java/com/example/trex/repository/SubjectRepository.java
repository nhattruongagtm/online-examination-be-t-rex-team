package com.example.trex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.trex.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

	List<Subject> findByStudentId(Long studentId);
}