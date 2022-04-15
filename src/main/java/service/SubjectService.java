package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trex.model.Subject;

import repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;

	public List<Subject> getAllByStudentId(Long studentId) {
		return subjectRepo.findAllByStudentId(studentId);
	}
}
