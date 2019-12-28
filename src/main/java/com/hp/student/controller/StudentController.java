package com.hp.student.controller;

import com.hp.student.model.Student;
import com.hp.student.repo.StudentRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentService){
        this.studentRepository = studentService;
    }

    //
    @GetMapping("/students")
    public Iterable<Student> retrieveAllStudents() {

        //List<Student> all_st = new List<Student>();
        return studentRepository.findAll();//.findAll();
    }

    //
    @GetMapping("st")
    public ResponseEntity<List<Student>> getAllEmployees() {
        Iterable<Student> list = studentRepository.findAll();

        return new ResponseEntity<List<Student>>((List<Student>) list, new HttpHeaders(), HttpStatus.OK);
    }

    //
    @GetMapping("/c")
    public Long ret() {

        //List<Student> all_st = new List<Student>();
        return studentRepository.count();//.findAll();
    }

    //
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

    //
    @RequestMapping("/home")
    public String home(){
        return "Y Y Y Y Y Y Y Y Y Y Y";
    }

}
