package com.hp.student.controller;

import com.hp.student.exception.ResourceNotFoundException;
import com.hp.student.model.Student;
import com.hp.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //
    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {

        return studentService.list();
    }


    //
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.getById(id);
    }


    //
    @GetMapping("/count")
    public Long getCount() {

        return studentService.getCount();
    }


    //
    @PostMapping("/register")
    public Student register(@Valid @RequestBody Student student){

        return studentService.save(student);
    }
    /*
    //
    @PutMapping("/{id}")
    public ResponseEntity<?> Update(@PathVariable ("id") Long id, @Valid @RequestBody Student student){

        Student currentStudent = studentService.getById(id);
        if (currentStudent == null){
            return new ResponseEntity<>(new ResourceNotFoundException("Unable to update student with idf" + id), HttpStatus.NOT_FOUND);
        }
        currentStudent.setName(student.getName());
        currentStudent.setPassportNumber(student.getPassportNumber());
        studentService.save(currentStudent);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }*/

    @PutMapping("/{id}")
    public Student update(@PathVariable (value = "id") Long id, @Valid @RequestBody Student student){

        return studentService.update(id, student);
    }

    /*
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id){

        Student student = studentService.getById(id);


        if (student == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        studentService.delete(id);
        return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Long id){

        studentService.delete(id);
    }


        @DeleteMapping("/")
        public ResponseEntity<Void> deleteAll(){

            studentService.deleteAll();
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

    //
    @RequestMapping("/home")
    public String home(){
        return "Y Y Y Y Y Y Y Y Y Y Y";
    }

}
