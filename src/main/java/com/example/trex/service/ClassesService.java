package com.example.trex.service;


import com.example.trex.model.Classes;
import com.example.trex.model.Subject;

import java.util.List;
import java.util.Optional;

public interface ClassesService {
    List<Classes> getStudentId(Long userId);
    boolean checkClassIsPresent(Classes cl);
    Classes addClasses(Classes cl);
    List<Classes> getAllClass();
    List<Classes> getClassBySubjectID(long subjectID);

    Classes addClassesBySubjectId(long subjectId, Classes cl);
}
