package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InvoiceModel;
import com.example.demo.services.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService personService;

    @GetMapping()
    public ArrayList<InvoiceModel> getInvoice(){
        return personService.getInvoice();
    }

    @PostMapping()
    public InvoiceModel saveInvoice(@RequestBody InvoiceModel invoice){
        return this.personService.saveInvoice(invoice);
    }

    @GetMapping( path = "/{id}")
    public Optional<InvoiceModel> getById(@PathVariable("id") Long id) {
        return this.personService.getById(id);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteInvoice(@PathVariable("id") Long id){
        boolean ok = this.personService.deleteInvoice(id);
        if (ok){
            return "Se eliminó la factura con id " + id;
        }else{
            return "No pudo eliminar la factura con id" + id;
        }
    }
}