package com.example.trex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(account = "userName")
	private String userName;
	private String password;

	public User(String userName, String password){
		this.userName=userName;
		this.password=password;
	}

	public void updateUserContacts(String userName, String password) {
		User myUser = repo.findById(userName);
		myUser.password = password;
		repo.save(myUser);
	}

}
