package com.example.trex.controllers;

import com.example.trex.model.Classes;
import com.example.trex.model.ResponseObject;
import com.example.trex.model.Subject;
import com.example.trex.model.User;
import com.example.trex.service.ClassesService;
import com.example.trex.service.SubjectService;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClassesController {
    @Autowired
    UserService userService;
    @Autowired
    ClassesService classesService;
    @PostMapping("/addStuToClass/{id}")
    public ResponseEntity<?> addStudentToClass(@PathVariable(value = "id") Long id,@RequestBody Classes cl){
        User u = userService.getUserByID(id);
        if (cl != null){
            u.setClasses(cl);
            userService.save(u);
            return ResponseEntity.ok("Add Student To Class Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add Student To Class Error");
    }

    @PostMapping("/addClass")
    public ResponseEntity addClasses(@RequestBody Classes cl){
        if (classesService.checkClassIsPresent(cl) == true){
            Classes cls = classesService.addClasses(cl);
            return ResponseEntity.ok(cls);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Add Class Error");
    }

    @GetMapping("/getAllClass")
    public ResponseEntity getAllClass(){
        List<Classes> result = classesService.getAllClass();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/subject/{subjectId}/addClass")
    public ResponseEntity<ResponseObject> createClassBySubjectId(
            @PathVariable(value = "subjectId") long subjectId,
            @RequestBody Classes classes
    ){
       Classes createdClasses = classesService.addClassesBySubjectId(subjectId,classes);
       return ResponseEntity.status(HttpStatus.OK).body(
               new ResponseObject(
                       "ok",
                       "Thêm lớp thành công",
                       classes
               )
       );
    }
}
