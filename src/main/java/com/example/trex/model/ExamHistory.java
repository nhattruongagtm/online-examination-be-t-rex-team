package com.example.trex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamHistory {

    public ExamHistory(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "date_exam")
    private Date dateExam;

    @Column(name = "correct")
    private int correct;

    @Column(name = "total")
    private int total;



}
