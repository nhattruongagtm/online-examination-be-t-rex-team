package com.example.trex.service.impl;

import java.util.List;

import com.example.trex.dto.SubjectRequest;
import com.example.trex.model.Student;
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

	@Override
	public String insertSubject(long studentId, SubjectRequest subjectRequest) {
		Subject subject = new Subject(subjectRequest);
		if (subjectRepo.findByName(
				subject.getName()
		).size() > 0
		) {
			return "Tên môn đã tồn tại";
		}
		Student student = new Student(studentId, "Diem My");
		subject.setStudent(student);
		subjectRepo.save(subject);
		return "Thêm môn thành công";
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

}
