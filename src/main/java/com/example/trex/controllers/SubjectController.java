package com.example.trex.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trex.model.Subject;

import service.ISubjectService;

@RestController
public class SubjectController {

	private ISubjectService subjectService;

	@GetMapping("subject/{studentId}")
	public ResponseEntity<List<Subject>> getAll(@PathParam(value = "studentId") Long studentId) {
		
		List<Subject> result = subjectService.getAllByStudentId(studentId);
		return ResponseEntity.ok(result);
	}
}
