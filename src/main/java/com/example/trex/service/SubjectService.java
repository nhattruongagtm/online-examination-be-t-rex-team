package com.example.trex.service;

import java.util.List;

import com.example.trex.model.Subject;

public interface SubjectService {
	List<Subject> getAllByStudentId(Long userId);
	Subject insertSubject(Subject subject);
	String deleteSubject(long id);
}
