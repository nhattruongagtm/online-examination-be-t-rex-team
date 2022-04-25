package com.example.trex.service.impl;

import com.example.trex.model.Classes;
import com.example.trex.repository.ClassesRespository;
import com.example.trex.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRespository classRepo;

    public List<Classes> getStudentId(Long studentId) {
        return null;
    }
}
