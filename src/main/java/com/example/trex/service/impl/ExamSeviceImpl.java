package com.example.trex.service.impl;

import com.example.trex.dto.ExamDTO;
import com.example.trex.model.Classes;
import com.example.trex.model.Exam;
import com.example.trex.model.Subject;
import com.example.trex.model.User;
import com.example.trex.repository.ExamRepository;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamSeviceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkTestPermission(Long id, Exam exam) {
        List<Exam> exams = examRepository.findExamByIdAndDate(exam.getId(),exam.getDate());
        Exam myExam = examRepository.getById(exam.getId());
        Optional<User> user = userRepository.findById(id);
        boolean isFound = false;
       if(user.isPresent()){
           Subject subject = myExam.getSubject();
           List<Classes> classes = subject.getClasses();
           for(Classes clas : classes) {
               for (User u : clas.getU()) {
                   if (u.getId() == id) {
                       isFound = true;
                   }
               }
           }
           if(exams.size() > 0 && isFound){
               return true;
           }
           return false;
       }
       return false;
    }
    @Override
    public Exam getExam(Long id) {
        return examRepository.getById(id);

    }

    @Override
    public List<Exam> getListExam(Long id) {
        return examRepository.findByUserId(id);
    }

    @Override
    public Exam loadExam(String code) {
        String[] codes = code.split("/");
        Long subjectCode = Long.parseLong(codes[0]);
        Date examDate = Date.valueOf(codes[1]);
        List<Exam> e = examRepository.findExamByIdAndDate(subjectCode,examDate);
        return e.size() > 0 ? e.get(0) : null;
    }

    @Override
    public List<ExamDTO> getExamListByStudentID(Long id) {
        List<Exam> exams = examRepository.findAll();
        List<ExamDTO> rs = new ArrayList<>();
        for(Exam exam : exams){
            Subject subject = exam.getSubject();
            for(Classes classes : subject.getClasses()){
                for(User u : classes.getU()){
                    if(u.getId().equals(id)){
                        ExamDTO e = new ExamDTO();
                        e.setId(exam.getId());
                        e.setDuration(exam.getDuration());
                        e.setDate(exam.getDate());
                        e.setSubjectName(subject.getName());
                        e.setSubjectID(subject.getId());
                        e.setTime(exam.getTime());
                        e.setCode(subject.getCode());

                        rs.add(e);
                    }
                }
            }
        }
       return rs;

    }
}
