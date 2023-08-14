package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.InvoiceModel;
import com.example.demo.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired

    public ArrayList<InvoiceModel> getInvoice() {
        return (ArrayList<InvoiceModel>) invoiceRepository.findAll();
    }

    public Optional<InvoiceModel> getById(Long id) {
        return invoiceRepository.findById(id);
    }

    public InvoiceModel saveInvoice(InvoiceModel invoice) {
        return invoiceRepository.save(invoice);

    }

    public boolean deleteInvoice(Long id) {
        try {
            invoiceRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}