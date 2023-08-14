package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InvoiceModel;
import com.example.demo.models.InvoiceRequestModel;
import com.example.demo.models.PersonModel;
import com.example.demo.services.InvoiceService;
import com.example.demo.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PersonService personService;

    @GetMapping()
    public ArrayList<InvoiceModel> getInvoice() {
        return invoiceService.getInvoice();
    }

    @GetMapping(path = "/{id}")
    public Optional<InvoiceModel> getById(@PathVariable("id") Long id) {
        return this.invoiceService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<String> saveInvoice(@RequestBody InvoiceRequestModel invoice) {
        PersonModel person = personService.getById(invoice.getPersonId());

        if (person != null) {
            InvoiceModel invoiceModel = new InvoiceModel();
            invoiceModel.setAmount(invoice.getAmount());
            invoiceModel.setDate(invoice.getDate());
            invoiceModel.setPerson(person);
            this.invoiceService.saveInvoice(invoiceModel);
            return ResponseEntity.ok("Invoice added successfully.");
        }

        return ResponseEntity.badRequest().body("Person not found.");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable("id") Long id) {
        boolean ok = this.invoiceService.deleteInvoice(id);
        if (ok) {
            return ResponseEntity.ok("Se eliminó la factura con id " + id);
        } else {
            return ResponseEntity.ok("No pudo eliminar la factura con id" + id);
        }
    }
}