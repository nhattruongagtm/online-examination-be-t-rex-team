package com.example.trex.service;

import java.util.List;
import java.util.Map;

import com.example.trex.dto.SubjectRequest;
import com.example.trex.model.Subject;

public interface SubjectService {
	List<Subject> getAllByStudentId(Long userId);
	List<Subject> getListSubjectIdTeacher(Long Id);
	Map<String,Object> insertSubject(long studentId, SubjectRequest subjectRequest);
	String deleteSubject(long id);
}
