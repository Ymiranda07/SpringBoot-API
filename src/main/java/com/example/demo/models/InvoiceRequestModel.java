package com.example.demo.models;

import java.time.LocalDate;

public class InvoiceRequestModel {
    private LocalDate date;
    private int amount;
    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}