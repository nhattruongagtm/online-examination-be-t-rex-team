package com.example.trex.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.trex.model.Subject;

import com.example.trex.service.SubjectService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	/**
	 * function to get get list subject by user_id
	 * @param: studentId
	 * @return: list of subject as json
	 */
	@GetMapping("subject/{studentId}")
	public ResponseEntity<List<Subject>> getAll(@PathVariable(value = "studentId") Long studentId) {
		List<Subject> result = subjectService.getAllByStudentId(studentId);
		return ResponseEntity.ok(result);
	}
}
