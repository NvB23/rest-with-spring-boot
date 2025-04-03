package com.naum.restwithspringboot.services;

import com.naum.restwithspringboot.data.dto.v1.PersonDTO;
import com.naum.restwithspringboot.data.dto.v2.PersonDTOV2;
import com.naum.restwithspringboot.exception.ResourceNotFoundException;
import static com.naum.restwithspringboot.mapper.ObjectMapper.parseObject;
import static com.naum.restwithspringboot.mapper.ObjectMapper.parseListObjects;

import com.naum.restwithspringboot.mapper.custom.PersonMapper;
import com.naum.restwithspringboot.models.Person;
import com.naum.restwithspringboot.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper converter;

    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding all people.");
        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one new person.");
        var entity = parseObject(person, Person.class);
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one new person with V2.");
        var entity = converter.convertToEntity(person);
        return converter.convertToDTOV2(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one person.");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one person.");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        return parseObject(entity, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person.");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id."));
        personRepository.delete(person);
    }
}
