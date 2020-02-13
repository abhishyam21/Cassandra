package com.learning.controllers;

import com.learning.database.model.PersonEntity;
import com.learning.models.PersonRequest;
import com.learning.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "people")
    public ResponseEntity<List<PersonEntity>> getAllPeople(){
        log.info("In Get all people request");
        List<PersonEntity> allPeople = peopleService.getAllPeople();
        return new ResponseEntity<>(allPeople, HttpStatus.OK);
    }

    @PostMapping(value = "people")
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest personRequest){
        log.info("In create person request");
        String id = peopleService.createPerson(personRequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "people/{personName}")
    public ResponseEntity<String> deletePerson(@PathVariable String personName){
            log.info("Delete person request");
            peopleService.deletePerson(personName);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
