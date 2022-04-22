package com.example.trex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
}
