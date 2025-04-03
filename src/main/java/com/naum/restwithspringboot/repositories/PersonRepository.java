package com.naum.restwithspringboot.repositories;

import com.naum.restwithspringboot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
