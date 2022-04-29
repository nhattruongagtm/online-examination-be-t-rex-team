package com.example.trex.service;


import com.example.trex.model.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> getStudentId(Long userId);
    boolean checkClassIsPresent(Classes cl);
    Classes addClasses(Classes cl);
    List<Classes> getAllClass();

    Classes addClassesBySubjectId(long subjectId, Classes cl);
}
