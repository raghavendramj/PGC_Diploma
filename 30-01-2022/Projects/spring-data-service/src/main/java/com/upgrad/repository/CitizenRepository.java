package com.upgrad.repository;

import com.upgrad.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Citizen findByFirstNameAndLastName(String firstName, String lastName);

    Citizen findByEmail(String emailId);

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}
