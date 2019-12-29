package com.hp.student.service;

import com.hp.student.model.Student;
import com.hp.student.repo.StudentRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
         studentRepository.deleteById(id);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }

}
