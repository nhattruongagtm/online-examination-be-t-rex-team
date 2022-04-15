package service;

import java.util.List;

import com.example.trex.model.Subject;

public interface ISubjectService {
	List<Subject> getAllByStudentId(Long userId);
}
