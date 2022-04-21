package com.example.trex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trex.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	<S extends User> S save(S entity);

	User findByUsername(String userName);

	Optional<User> findById(Long id);
	User findByEmail(String email);
	User findByToken(String token);
}
