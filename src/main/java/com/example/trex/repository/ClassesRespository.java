package com.example.trex.repository;

import java.util.List;

import com.example.trex.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassesRespository extends JpaRepository<Classes, Long> {

}
