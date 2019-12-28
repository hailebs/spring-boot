package com.hp.student.repo;
import com.hp.student.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Long> {

    //studentRepository.deleteById(id)
    //Student st = new Student();
    //
    //
    //@Query("select s from Student s")
    //Stream<Student> findAllAndStream();
}