package com.naum.rest_with_spring_boot.repositories;

import com.naum.rest_with_spring_boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
