package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.models.PersonModel;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepositoryl;

    public List<PersonModel> getPerson() {
        return (ArrayList<PersonModel>) personRepositoryl.findAll();
    }

    public PersonModel savePerson(PersonModel person) {
        return personRepositoryl.save(person);
    }

    public ArrayList<PersonModel> findByIdentifications(Integer identifications) {
        return personRepositoryl.findByIdentifications(identifications);
    }

    public boolean deletePerson(Long id) {
        try {
            personRepositoryl.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}