package com.example.trex.service.impl;

import com.example.trex.model.Classes;
import com.example.trex.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.repository.ClassRepository;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassRepository classRepo;

    public List<Classes> getStudentId(Long studentId) {
        return null;
    }
}
