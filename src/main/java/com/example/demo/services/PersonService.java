package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.InvoiceModel;
import com.example.demo.models.PersonModel;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonModel> getPerson() {
        return (ArrayList<PersonModel>) personRepository.findAll();
    }

    public PersonModel savePerson(PersonModel person) {
        return personRepository.save(person);
    }

    public PersonModel getById(Long id) {
        return personRepository.findPersonById(id);
    }

    public ArrayList<PersonModel> findByIdentifications(Integer identifications) {
        return personRepository.findByIdentifications(identifications);
    }

    public boolean deletePerson(Long id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}