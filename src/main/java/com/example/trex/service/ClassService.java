package com.example.trex.service;


import com.example.trex.model.Classes;

import java.util.List;

public interface ClassService {
    List<Classes> getStudentId(Long userId);
}
