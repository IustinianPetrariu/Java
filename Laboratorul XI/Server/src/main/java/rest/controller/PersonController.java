package rest.controller;


import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.exceptions.CustomNotFoundException;
import rest.model.Person;
import rest.repository.PersonRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {


    @Autowired   /// Spring dependency injection -alternative to Java EE Inject annotation
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Person create(@Valid @NotNull @RequestParam String name) {
        Person person = new Person();
        person.setName(name);
        return repository.save(person);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Person person = repository.findOne(id);
        if(person == null)
            return new ResponseEntity<String>("Person with id = " + id + "not found", HttpStatus.GONE);
        else
        {
            repository.delete(id);
            return new ResponseEntity<String>("Person with id = " + id + "has been deleted from db", HttpStatus.OK);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> update(@Valid @NotNull @RequestParam String name, @PathVariable("id") Integer id) throws BadHttpRequest {
        if (repository.exists(id)) {
           Person person = repository.findOne(id);
           person.setName(name);
           repository.save(person);
        } else {
            throw new BadHttpRequest();
        }
        return new ResponseEntity<>(
                "Person with id = " + id + " has been updated successsfully", HttpStatus.OK);
    }

    @GetMapping(value="/search/{id}")
    public Person getPerson(@PathVariable("id") Integer id) throws BadHttpRequest {
        Person person = repository.findOne(id);
        if(person == null)
            throw new CustomNotFoundException("Not found person with this id= " + id);
        else
        {
            return person;
        }

    }
}
