package com.example.trex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    public Question(int correct){
        this.correct = correct;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "correct")
    private int correct;

    @ManyToOne
    @JoinColumn(name = "id_subject",referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_exam",referencedColumnName = "id")
    private Exam exam;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
}
