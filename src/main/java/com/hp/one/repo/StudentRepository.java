package com.hp.one.repo;
import com.hp.one.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    Student st = new Student();
    //
    //
}