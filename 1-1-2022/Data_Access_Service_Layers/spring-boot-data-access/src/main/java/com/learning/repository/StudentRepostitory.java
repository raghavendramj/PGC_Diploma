package com.learning.repository;

import com.learning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepostitory extends JpaRepository<Student, Long> {
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    Student findByFirstNameAndLastName(String firstName, String lastName);

    Student findByEmailId(String emailId);
}
