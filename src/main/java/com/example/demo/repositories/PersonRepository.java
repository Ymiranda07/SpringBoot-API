package com.example.demo.repositories;

import java.util.ArrayList;
import com.example.demo.models.PersonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {
    public abstract ArrayList<PersonModel> findByIdentifications(Integer identifications);
}