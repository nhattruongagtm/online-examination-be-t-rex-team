package com.example.trex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

	public Student(Long id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fullname")
	private String fullname;

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Subject> subjects;

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<ExamHistory> examHistories;
	public Student(Long id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}
}
