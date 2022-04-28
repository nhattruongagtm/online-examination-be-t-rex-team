package com.example.trex.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject")
@Setter
@Getter
@NoArgsConstructor
public class Subject {

	public Subject(Long id){
		this.id = id;
	}
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<ExamHistory> examHistories;

	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<Exam> examList;

	@OneToMany(mappedBy = "subject")
	private List<Classes> classes;

	public Subject(String name, String code, Date examDate, Integer examTime, Double grade) {
		this.name = name;
		this.code = code;
		this.examDate = examDate;
		this.examTime = examTime;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				", examDate=" + examDate +
				", examTime=" + examTime +
				", grade=" + grade +
				", student=" + student +
				", examHistories=" + examHistories +
				", examList=" + examList +
				", classes=" + classes +
				'}';
	}
}
