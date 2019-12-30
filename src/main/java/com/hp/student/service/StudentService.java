package com.hp.student.service;

import com.hp.student.exception.ResourceNotFoundException;
import com.hp.student.model.Student;
import com.hp.student.repo.StudentRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save (Student student){
        return studentRepository.save(student);
    }
    public Student update (Long id, Student student) {

        Student currentStudent = studentRepository.getById(student.getId());
        if (currentStudent == null) {
            return new ResponseEntity<Student>(new ResourceNotFoundException("Unable to update student with idf" + student.getId()), HttpStatus.NOT_FOUND);
        }
        currentStudent.setName(student.getName());
        currentStudent.setPassportNumber(student.getPassportNumber());
        studentRepository.save(currentStudent);
        //return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }

    public List<Student> list(){
        return studentRepository.findAllByOrderByIdAsc();
    }

    public Student getById(Long id){
        return studentRepository.getById(id);
    }

    public Long getCount(){
        return studentRepository.count();
    }
    public boolean exists(Long id){
        return studentRepository.existsById(id);
    }

    public void delete(Long id){

        Student student = studentRepository.getById(id);


        if (student == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
         studentRepository.deleteById(id);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }

}
