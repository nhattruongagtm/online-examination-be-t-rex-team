package com.example.trex.service.impl;

import com.example.trex.dto.AnswerRequest;
import com.example.trex.model.ExamHistory;
import com.example.trex.model.Question;
import com.example.trex.model.Student;
import com.example.trex.model.Subject;
import com.example.trex.repository.ExamHistoryRepository;
import com.example.trex.dto.QuestionRequest;
import com.example.trex.model.*;
import com.example.trex.repository.AnswerRepository;

import com.example.trex.repository.ExamRepository;
import com.example.trex.repository.QuestionRepository;
import com.example.trex.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ExamHistoryRepository examHistoryRepository;

    @Autowired
    private ExamRepository examRepository;

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

        if(request.getExamDate() == null){
            examHistory.setDateExam(new Date(System.currentTimeMillis()));
        }else{
            examHistory.setDateExam(request.getExamDate());
        }

        if(request.getDuration() != null)
            examHistory.setDuration(request.getDuration());
        else
            examHistory.setDuration(60);

        examHistory = examHistoryRepository.save(examHistory);

        examHistory.setCorrect(correct);
        examHistory.setTotal(total);

        return examHistory;
    }

    @Override
    public void saveListQuestion(QuestionRequest questionRequest) {
        List<Question> listQuestionRequest = questionRequest.getListQuestions();
        Subject subject = new Subject();
        subject.setId(questionRequest.getSubjectID());

        User user = new User();
        user.setId(questionRequest.getTeacherID());
        //save Exam.
        Exam exam = new Exam();

        exam.setDuration(questionRequest.getDuration());
        exam.setTime(questionRequest.getTime());
        exam.setDate(questionRequest.getDate());
        exam.setUser(user);
        exam.setDateCreated(questionRequest.getCreatedDate());
        exam.setSubject(subject);
        System.err.println(exam.getSubject().getId()+"exam....................");
        examRepository.save(exam);

        //
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

    @Override
    public List<Question> getListQuestion(Long idExam) {
        Exam exam = examRepository.findExamById(idExam);
        return questionRepository.findBySubjectId(exam.getId());
    }


    //load question

}
