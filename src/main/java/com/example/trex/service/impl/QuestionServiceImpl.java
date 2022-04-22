package com.example.trex.service.impl;

import com.example.trex.dto.AnswerRequest;
import com.example.trex.model.ExamHistory;
import com.example.trex.model.Question;
import com.example.trex.model.Student;
import com.example.trex.model.Subject;
import com.example.trex.repository.QuestionRepository;
import com.example.trex.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public ExamHistory getCorrect(AnswerRequest request) {
        ExamHistory examHistory = new ExamHistory();
        examHistory.setStudent(new Student(request.getStudentId()));
        examHistory.setSubject(new Subject(request.getSubjectId()));

        int correct = 0;
        int total = request.getAnswers().size();

        // xu ly so cau hoi dung
        Question question;
        for(int i = 0; i < total; i++){
            Long questionId = request.getAnswers().get(i).getId();
            question = questionRepository.findById(questionId).orElse(new Question(4));
            try{
                int a = question.getCorrect();
                int b = request.getAnswers().get(i).getAnswer();
                if(a == b){
                    correct++;
                }
            }catch (Exception e){
                System.out.println();
            }

        }

        examHistory.setCorrect(correct);
        examHistory.setTotal(total);

        return examHistory;
    }
}
