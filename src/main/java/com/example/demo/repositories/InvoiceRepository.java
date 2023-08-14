package com.example.demo.repositories;

import com.example.demo.models.InvoiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceModel, Long> {

}