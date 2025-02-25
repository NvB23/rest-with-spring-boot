package com.naum.rest_with_spring_boot.services;

import com.naum.rest_with_spring_boot.exception.ResourceNotFoundException;
import com.naum.rest_with_spring_boot.models.Person;
import com.naum.rest_with_spring_boot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all people.");
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one new person.");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person.");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }


    public Person findById(Long id) {
        logger.info("Finding one person.");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
    }

    public void delete(Long id) {
        logger.info("Deleting one person.");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        personRepository.delete(person);
    }
}
