package com.example.trex.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject")
@Setter
@Getter
@NoArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "exam_date")
	@Temporal(TemporalType.DATE)
	private Date examDate;

	@Column(name = "exam_time")
	private Integer examTime;

	@Column(name = "exam_grade")
	private Double grade;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	public Subject(String name, String code, Date examDate, Integer examTime, Double grade) {
		this.name = name;
		this.code = code;
		this.examDate = examDate;
		this.examTime = examTime;
		this.grade = grade;
	}
}
