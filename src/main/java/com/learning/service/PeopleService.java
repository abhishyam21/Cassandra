package com.learning.service;

import com.learning.database.model.PersonEntity;
import com.learning.database.repo.PeopleRepo;
import com.learning.models.PersonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PeopleService {

    @Autowired
    private PeopleRepo peopleRepo;
    public List<PersonEntity> getAllPeople() {
        return peopleRepo.findAll();
    }

    public String createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = PersonEntity.createPerson(personRequest.getName(), personRequest.getAge());
        personEntity = peopleRepo.save(personEntity);
        return personEntity.getId().toString();
    }

    public void deletePerson(String personName) {
        PersonEntity personEntity = peopleRepo.findByName(personName);
        peopleRepo.delete(personEntity);
        log.info("Deleted person {}",personName);
    }
}
