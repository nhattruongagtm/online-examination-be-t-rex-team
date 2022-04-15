package com.example.trex.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trex.model.Student;
import com.example.trex.model.Subject;

import service.ISubjectService;

@RestController
public class SubjectController {

	private ISubjectService subjectService;

	@GetMapping("subject/{studentId}")
	public ResponseEntity<List<Subject>> getAll(@PathParam(value = "studentId") Long studentId) {

//		List<Subject> result = subjectService.getAllByStudentId(studentId);
		List<Subject> result = new ArrayList<Subject>();

		Subject subject = new Subject();
		subject.setId(1l);
		subject.setName("Agile");
		subject.setStudent(new Student(1l, "Phi Hung"));

		result.add(subject);

		return ResponseEntity.ok(result);
	}
}
