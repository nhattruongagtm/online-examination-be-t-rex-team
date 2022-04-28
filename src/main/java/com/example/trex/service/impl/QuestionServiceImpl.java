package com.example.trex.service.impl;

import com.example.trex.dto.AnswerRequest;
import com.example.trex.dto.QuestionRequest;
import com.example.trex.model.*;
import com.example.trex.repository.AnswerRepository;
import com.example.trex.repository.QuestionRepository;
import com.example.trex.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

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

    @Override
    public void saveListQuestion(QuestionRequest questionRequest) {
        List<Question> listQuestionRequest = questionRequest.getListQuestions();
        Subject subject = new Subject();
        System.err.println(questionRequest.getIdSubject());
        subject.setId(questionRequest.getIdSubject());
        for (int i = 0;i<listQuestionRequest.size();i++){
            Question question = listQuestionRequest.get(i);
            question.setSubject(subject);
            System.err.println(subject.toString());
            questionRepository.save(question);
            for (int k = 0; k<listQuestionRequest.get(i).getAnswers().size();k++){
                Answer answer = listQuestionRequest.get(i).getAnswers().get(k);
                answer.setQuestion(question);
                System.err.println(answer);
                answerRepository.save(answer);
            }
        }
    }

}
