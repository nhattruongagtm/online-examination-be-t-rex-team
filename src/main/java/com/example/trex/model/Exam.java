package com.example.trex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.trex.model.Subject;

@Entity
@Table(name = "exam")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int duration;

    @Temporal(TemporalType.DATE)
    private Date date;
    private Date dateCreated;
    private Time time;
    @ManyToOne
    @JoinColumn(name = "idTeacher", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
    
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", duration=" + duration +
                ", date=" + date +
                ", time=" + time +
                ", idUser=" + user.getId() +
                ", subject=" + subject.getName() +
                '}';
    }
}
