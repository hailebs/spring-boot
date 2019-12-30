package com.hp.student.repo;
import com.hp.student.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Long> {

    <S extends Student> S save (S entity);
    //Student  save (Student student);

    List<Student> findAllByOrderByIdAsc();

    Student getById(Long id);

    long count();
/*
    Student update(Student student );
*/
    void deleteById(Long id);

    boolean existsById(Long id);

    void deleteAll();
}