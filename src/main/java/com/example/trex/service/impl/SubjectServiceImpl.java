package com.example.trex.service.impl;

import java.util.List;

import com.example.trex.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trex.model.Subject;

import com.example.trex.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;

	public List<Subject> getAllByStudentId(Long studentId) {
		List<Subject> listSubject = subjectRepo.findByStudentId(studentId);
		return listSubject;
	}
}
