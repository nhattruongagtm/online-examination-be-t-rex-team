package com.example.trex.controllers;

import java.util.List;

import com.example.trex.dto.SubjectRequest;
import com.example.trex.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@PostMapping("subject/add-subject/{studentId}")
	public ResponseEntity<ResponseObject> insertSubject(@RequestBody SubjectRequest subjectRequest,
														@PathVariable long studentId){
		String message = subjectService.insertSubject(studentId,subjectRequest);
		return
				ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(
								"ok",
								message,
								subjectRequest
						)
				);
	}
	@DeleteMapping("subject/{id}")
	public ResponseEntity<ResponseObject> deleteSubject(
			@PathVariable long id
	){
		String message = subjectService.deleteSubject(id);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject(
						"ok",
						message,
						""+id
				)
		);
	}
}
