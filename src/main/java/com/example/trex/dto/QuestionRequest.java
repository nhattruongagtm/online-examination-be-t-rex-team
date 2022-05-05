package com.example.trex.dto;

import com.example.trex.model.Exam;
import com.example.trex.model.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private Long subjectID;
    private Long teacherID;
    private Time time;
    private Date date;
    private int duration;
    private Date createdDate;
    private List<Question> listQuestions;
}
