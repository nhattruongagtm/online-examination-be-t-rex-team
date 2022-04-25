package com.example.trex.service;


import com.example.trex.model.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> getStudentId(Long userId);
}
