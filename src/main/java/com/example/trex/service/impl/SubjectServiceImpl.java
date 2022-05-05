package com.example.trex.service.impl;

import java.util.*;

import com.example.trex.dto.SubjectRequest;
import com.example.trex.model.Exam;
import com.example.trex.model.Student;
import com.example.trex.model.User;
import com.example.trex.repository.ExamRepository;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trex.model.Subject;

import com.example.trex.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;

	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private UserRepository userRepository;
	public List<Subject> getAllByStudentId(Long studentId) {
		List<Subject> listSubject = subjectRepo.findByStudentId(studentId);
		return listSubject;
	}


	@Override
	public Map<String, Object> insertSubject(long studentId, SubjectRequest subjectRequest) {
		Map<String, Object> result= new HashMap<>();
		Subject subject = new Subject(subjectRequest);
		if (subjectRepo.findByName(
				subject.getName()
		).size() > 0
		) {
			result.put("msg","Tên môn đã tồn tại");
			return result;
		}
		Optional<User> userOptional = userRepository.findById(935L);
		if(!userOptional.isPresent()){
			result.put("msg","Giáo viên không tồn tại");
			return result;
		}
		User user = userOptional.get();
		Student student = new Student(studentId, "Diem My");
		subject.setStudent(student);
		subject.setUser(user);
		subject = subjectRepo.save(subject);
		result.put("msg","Thêm môn thành công");
		result.put("subject",subject);
		return result;
	}

	@Override
	public String deleteSubject(long id) {
		boolean isExist = subjectRepo.existsById(id);
		if(isExist){
			subjectRepo.deleteById(id);
			return "Xóa môn thành công";
		}else{
			return "Môn không tồn tại";
		}
	}


	@Override
	public List<Subject> getListSubjectIdTeacher(Long Id) {

		return subjectRepo.findByUserId(Id);
	}

}
