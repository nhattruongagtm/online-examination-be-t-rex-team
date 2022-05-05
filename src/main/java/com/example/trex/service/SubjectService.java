package com.example.trex.service;

import java.util.List;

import com.example.trex.dto.SubjectRequest;
import com.example.trex.model.Subject;

public interface SubjectService {
	List<Subject> getAllByStudentId(Long userId);
	String insertSubject(long studentId, SubjectRequest subjectRequest);
	String deleteSubject(long id);
}
