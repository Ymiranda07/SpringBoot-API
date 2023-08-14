package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.models.PersonModel;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<PersonModel> getPerson() {
        return personService.getPerson();
    }

    @PostMapping()
    @CrossOrigin()
    public PersonModel savePerson(@RequestBody PersonModel person) {
        return this.personService.savePerson(person);
    }

    @GetMapping(path = "/query")
    public ArrayList<PersonModel> getByIdentifications(@RequestParam("identifications") Integer identifications) {
        return this.personService.findByIdentifications(identifications);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePerson(@PathVariable("identifications") Long id) {
        boolean ok = this.personService.deletePerson(id);
        if (ok) {
            return "Se eliminó la persona con id " + id;
        } else {
            return "No pudo eliminar la persona con id" + id;
        }
    }
}