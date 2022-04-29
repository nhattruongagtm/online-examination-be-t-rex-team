package com.example.trex.service.impl;

import com.example.trex.model.Classes;
import com.example.trex.repository.ClassesRespository;
import com.example.trex.repository.SubjectRepository;
import com.example.trex.service.ClassesService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRespository classesRespository;
    @Autowired
    private SubjectRepository subjectRespository;

    public List<Classes> getStudentId(Long studentId) {
        return null;
    }

    @Override
    public boolean checkClassIsPresent(Classes cl) {
        List<Classes> cls = classesRespository.findAll();
        try {
            for (int i = 0; i < cls.size(); i++) {
                if (cls.get(i).getClassID() == cl.getClassID()) {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Classes addClasses(Classes cl) {
        return classesRespository.save(cl);
    }

    @Override
    public List<Classes> getAllClass() {
        return classesRespository.findAll();
    }

    @Override
    public Classes addClassesBySubjectId(long subjectId, Classes cl) {
        Classes createdClasses = subjectRespository.findById(subjectId).map(
                subject -> {
                    cl.setSubject(subject);
                    return classesRespository.save(cl);
                }
        ).orElseThrow(() -> new RuntimeException("Not found Subject with id = " + subjectId));
        return createdClasses;
    }

}

