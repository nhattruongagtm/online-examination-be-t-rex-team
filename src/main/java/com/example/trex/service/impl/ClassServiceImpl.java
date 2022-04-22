package com.example.trex.service.impl;

import com.example.trex.model.Classes;
import com.example.trex.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.repository.ClassRepository;

import java.util.List;

public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepo;

    public List<Classes> getStudentId(Long studentId) {
        return null;
    }
}
